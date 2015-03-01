package primitive;

import util.DeltaModUtil;
import value.ModulatedValue;

public class DynCircle extends DynamicPrimitive {
    public DynCircle() {
        super();
    }

    public DynCircle(ModulatedValue x, ModulatedValue y, ModulatedValue w, ModulatedValue h) {
        super(x, y, w, h);
    }

    public void render() {
        DeltaModUtil.fill(getG().getColor());
        DeltaModUtil.ellipse(getX().val(), getY().val(), getW().val(), getH().val());
    }
}
