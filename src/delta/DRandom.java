package delta;
import util.DeltaModUtil;
import value.Value;

public class DRandom extends Delta {
    public float transform(Value value) {
        return Math.round(DeltaModUtil.random(min, max));
    }
}