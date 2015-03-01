package delta;

public class DPingPong extends DLinear {
    public DPingPong () {
        super();
    }

    public DPingPong(float r) {
        super(r);
    }

    public void react() {
        setRate(getRate() * -1);
    }
}

