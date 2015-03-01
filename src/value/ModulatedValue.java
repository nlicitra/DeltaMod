package value;
import delta.Delta;

public  class ModulatedValue extends Value {
    float min, max;
    Delta delta;

    public ModulatedValue() {
        min = max = 0;
        delta = null;
    }

    public ModulatedValue(float min, float max, Delta delta) {
        super(min);
        this.min = min;
        this.max = max;
        this.delta = delta;
        this.delta.init(min, max);
    }

    public ModulatedValue(float initialValue, float min, float max, Delta delta) {
        super(initialValue);
        this.min = min;
        this.max = max;
        this.delta = delta;
        this.delta.init(min, max);
    }

    public void update() {
        v = delta.getNext(this);
    }
}
