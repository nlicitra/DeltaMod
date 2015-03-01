import color.Gradiant;
import primitive.DynTriangle;
import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;
import scene.*;
import util.DeltaModUtil;
import value.*;
import delta.*;
import primitive.*;

import java.util.ArrayList;

public class DeltaMod extends PApplet {
    Minim minim;
    AudioInput audioIn;
    AudioOutput audioOut;
    FFT fft;

    SceneManager sceneManager;

    Gradiant g;

    int windowWidth = 800;
    int windowHeight = 600;

    public void setup() {
        DeltaModUtil.setApplet(this);
        size(windowWidth, windowHeight);
        background(color(0, 0, 0));

        minim = new Minim(this);
        audioIn = minim.getLineIn(Minim.MONO, 1024, 44100);
        audioOut = minim.getLineOut();

        fft = new FFT(audioIn.bufferSize(), audioIn.sampleRate());
        fft.window(FFT.HAMMING);

        sceneManager = new SceneManager();
        sceneManager.addScene(createSceneA());
        sceneManager.addScene(createSceneB());
        sceneManager.addScene(createSceneC());
        sceneManager.addScene(createSceneD());
        sceneManager.addScene(createSceneE());

        g = new Gradiant();

        rectMode(CENTER);
        //noStroke();
        frameRate(60);
    }

    public void draw() {
        g.update();
        background(g.getColor());
        sceneManager.tick();
    }

    public void mousePressed() {
        sceneManager.onClick();
    }

    public void keyPressed() {
        sceneManager.onKey();
    }

    public int randomColor () {
        return color(random(255), random(255), random(255));
    }

    public void stop () {
        audioIn.close();
        minim.stop();

        super.stop();
    }

    private int getRandomSign() {
        int val = (int)(random(0,2));
        if (val > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private Scene createSceneA() {
        ModulatedValue x, y, size;
        DynTriangle shape;
        x = new ModulatedValue(50, 0, windowWidth, new DPingPong(10));
        y = new ModulatedValue(100, 0, windowHeight, new DPingPong(10));
        size = new ModulatedValue(30, 3, 200, new DPingPong(1));
        shape = new DynTriangle(x, y, size, size);
        return new Scene(shape);
    }

    private Scene createSceneB() {
        ArrayList<DynamicPrimitive> sceneShapes = new ArrayList<DynamicPrimitive>();
        ModulatedValue x, y, size;
        x = new ModulatedValue((windowWidth)/5, 0, windowWidth, new DConstant());
        y = new ModulatedValue(windowHeight/2, 0, windowHeight, new DConstant());
        size = new ModulatedValue(30, 3, 200, new DPingPong(1));
        sceneShapes.add(new DynCircle(x, y, size, size));
        x = new ModulatedValue((windowWidth*2.5f)/5, 0, windowWidth, new DConstant());
        sceneShapes.add(new DynCircle(x, y, size, size));
        x = new ModulatedValue((windowWidth*4)/5, 0, windowWidth, new DConstant());
        sceneShapes.add(new DynCircle(x, y, size, size));

        return new Scene(sceneShapes);
    }

    private Scene createSceneC() {
        ModulatedValue x, y, size;
        DynCircle shape;
        x = new ModulatedValue(windowWidth/2, 0, windowWidth, new DConstant());
        y = new ModulatedValue(windowHeight/2, 0, windowHeight, new DConstant());
        size = new ModulatedValue(30, 3, 500, new DAudio(audioIn));
        shape = new DynCircle(x, y, size, size);
        return new Scene(shape);
    }

    private Scene createSceneD() {
        ModulatedValue x, y, size;
        DynTriangle shape;
        x = new ModulatedValue(windowWidth/2, 0, windowWidth, new DConstant());
        y = new ModulatedValue(windowHeight/2, 0, windowHeight, new DConstant());
        size = new ModulatedValue(30, 3, 500, new DAudio(audioIn));
        shape = new DynTriangle(x, y, size, size);
        return new Scene(shape);
    }

    private Scene createSceneE() {
        ModulatedValue x, y, size;
        DynRectangle shape;
        x = new ModulatedValue(windowWidth/2, 0, windowWidth, new DConstant());
        y = new ModulatedValue(windowHeight/2, 0, windowHeight, new DConstant());
        size = new ModulatedValue(30, 3, 500, new DAudio(audioIn));
        shape = new DynRectangle(x, y, size, size);
        return new Scene(shape);
    }
}
