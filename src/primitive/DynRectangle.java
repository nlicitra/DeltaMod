package primitive;

import util.DeltaModUtil;
import value.ModulatedValue;

public class DynRectangle extends DynamicPrimitive {
    public DynRectangle() {
        super();
    }

    public DynRectangle(ModulatedValue x, ModulatedValue y, ModulatedValue w, ModulatedValue h) {
        super(x, y, w, h);
    }

    public void render() {
        DeltaModUtil.fill(getG().getColor());
        DeltaModUtil.rect(getX().val(), getY().val(), getW().val(), getH().val());
    }
}
