package color;
import processing.core.PApplet;
import util.DeltaModUtil;
import value.ModulatedValue;
import delta.*;

public class Gradiant {
    private ModulatedValue r;
    private ModulatedValue g;
    private ModulatedValue b;

    public Gradiant() {
        r = new ModulatedValue(0, 255, new DPingPong(1));
        g = new ModulatedValue(0, 255, new DPingPong(2));
        b = new ModulatedValue(0, 255, new DPingPong(3));
    }

    public Gradiant(float red, float green, float blue) {
        r = new ModulatedValue(red, 0, 255, new DPingPong(1));
        g = new ModulatedValue(green, 0, 255, new DPingPong(2));
        b = new ModulatedValue(blue, 0, 255, new DPingPong(3));
    }

    public void update() {
        r.update();
        g.update();
        b.update();
    }

    public int getColor() {
        return DeltaModUtil.getInstance().color(r.val(), g.val(), b.val());
    }
}
