package delta;
import value.Value;

public class DConstant extends Delta {
    public float transform(Value value) {
        return value.val();
    }
}
