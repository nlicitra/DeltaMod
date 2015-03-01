package util;

import processing.core.PApplet;

import java.util.Random;

public class DeltaModUtil {
    private static DeltaModUtil instance = null;
    private Random rand;
    private PApplet app;

    protected DeltaModUtil() {
        rand = new Random();
    }

    public static DeltaModUtil getInstance() {
        if (instance == null) {
            instance = new DeltaModUtil();
        }
        return instance;
    }

    public static float random(float min, float max) {
        return getInstance().rand.nextFloat() * (max - min);
    }

    public static void setApplet(PApplet app) {
        getInstance().setApp(app);
    }

    public void setApp(PApplet app) {
        this.app = app;
    }

    public static int millis() {
        return getInstance().app.millis();
    }

    public static int color (float r, float g, float b) {
        return getInstance().app.color(r, g, b);
    }

    public static void fill(int color) {
        getInstance().app.fill(color);
    }

    public static void rect(float x, float y, float w, float h) {
        getInstance().app.rect(x, y, w, h);
    }

    public static void ellipse(float x, float y, float w, float h) {
        getInstance().app.ellipse(x, y, w, h);
    }

    public static void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        getInstance().app.triangle(x1, y1, x2, y2, x3, y3);
    }
}
