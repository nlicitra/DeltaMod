package delta;
import value.*;

public abstract class DSequential extends Delta {
    public float getNext (Value value) {
        if (crossesThreshold(value)) {
            react();
        }
        return transform(value);
    }

    public abstract boolean crossesThreshold(Value value);
    public abstract void react();
}
