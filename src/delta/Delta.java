package delta;
import value.Value;

public abstract class Delta {
    float min, max;

    public void init  (float min, float max) {
        this.min = min;
        this.max = max;
    }

    public float getNext(Value value) {
        return transform(value);
    }

    public abstract float transform(Value value);
}
