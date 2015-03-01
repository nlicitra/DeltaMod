package primitive;

import util.DeltaModUtil;
import value.ModulatedValue;

public class DynTriangle extends DynamicPrimitive {
    public DynTriangle() {
        super();
    }

    public DynTriangle(ModulatedValue x, ModulatedValue y, ModulatedValue w, ModulatedValue h) {
        super(x, y, w, h);
    }

    public void render() {
        DeltaModUtil.fill(getG().getColor());
        DeltaModUtil.triangle(getX().val(), getY().val() - (getH().val() / 2), getX().val() - (getW().val() / 2), getY().val() + (getH().val() / 2), getX().val() + (getW().val() / 2), getY().val() + (getH().val() / 2));
    }
}
