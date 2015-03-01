package scene;

import primitive.DynamicPrimitive;
import util.DeltaModUtil;

public class SceneObject {
    private DynamicPrimitive object;
    private int startTime;
    private int lifeSpan;
    private boolean immortal;

    public SceneObject(DynamicPrimitive obj) {
        object = obj;
        immortal = true;
    }

    public SceneObject(DynamicPrimitive obj, int duration) {
        object = obj;
        startTime = DeltaModUtil.millis();
        lifeSpan = duration;
    }

    public boolean isExpired() {
        return !immortal && ((startTime + lifeSpan) < DeltaModUtil.millis());
    }

    public void update() {
        object.update();
    }

    public void render() {
        object.render();
    }

    public void tick() {
        update();
        render();
    }
}
