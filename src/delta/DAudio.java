package delta;
import processing.core.PApplet;
import value.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class DAudio extends Delta {
    private FFT fft;
    private AudioInput in;
    private float audioMax;
    private int counter;

    public DAudio (AudioInput input) {
        in = input;
        fft = new FFT(in.bufferSize(), in.sampleRate());
        fft.window(FFT.HAMMING);
    }

    public float transform(Value value) {
        fft.forward(in.mix);
        float audioLevel = fft.calcAvg(0, 20000);
        if (audioLevel > audioMax) {
            audioMax = audioLevel;
            counter = 0;
        } else {
            counter++;
        }

        if(counter > 120) {
            audioMax *= .75;
            counter = 0;
        }

        return PApplet.map(audioLevel, 0, audioMax, min, max);
    }
}
