package delta;
import value.Value;

public class DLinear extends DSequential {
    private float rate;
    private boolean reset;

    public DLinear () {
        rate = 0;
    }

    public DLinear(float r) {
        rate = r;
    }

    public boolean crossesThreshold (Value value) {
        if (rate > 0) {
            return (transform(value) > max);
        } else {
            return (transform(value) < min);
        }
    }

    public void react() {
        reset = true;
    }

    public float transform(Value value) {
        if (reset) {
            value.val(rate < 0 ? max : min);
            reset = false;
        }

        return value.val() + rate;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
