package primitive;
import util.DeltaModUtil;
import value.*;
import color.*;

public abstract class DynamicPrimitive {
    private ModulatedValue x, y, w, h;
    private Gradiant g;


    public DynamicPrimitive () {
        x = new ModulatedValue();
        y = new ModulatedValue();
        w = new ModulatedValue();
        h = new ModulatedValue();
        g = new Gradiant();
    }

    public DynamicPrimitive(ModulatedValue x, ModulatedValue y, ModulatedValue w, ModulatedValue h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        g = new Gradiant(DeltaModUtil.random(0, 255), DeltaModUtil.random(0, 255), DeltaModUtil.random(0, 255));
    }

    public void update() {
        x.update();
        y.update();
        w.update();
        h.update();
        g.update();
    }

    public abstract void render();

    public ModulatedValue getX() {
        return x;
    }

    public void setX(ModulatedValue x) {
        this.x = x;
    }

    public ModulatedValue getY() {
        return y;
    }

    public void setY(ModulatedValue y) {
        this.y = y;
    }

    public ModulatedValue getW() {
        return w;
    }

    public void setW(ModulatedValue w) {
        this.w = w;
    }

    public ModulatedValue getH() {
        return h;
    }

    public void setH(ModulatedValue h) {
        this.h = h;
    }

    public Gradiant getG() {
        return g;
    }

    public void setG(Gradiant g) {
        this.g = g;
    }
}
