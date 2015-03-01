package scene;

import util.DeltaModUtil;

import java.util.ArrayList;

public class TimedSceneManager extends SceneManager {
    private float interval;
    private float startTime;

    public TimedSceneManager() {
        setScenes(new ArrayList<Scene>());
        setStartTime();
    }

    public TimedSceneManager(float interval) {
        setScenes(new ArrayList<Scene>());
        this.interval = interval;
        setStartTime();
    }

    public TimedSceneManager(Scene scene) {
        setScenes(new ArrayList<Scene>());
        setStartTime();
        addScene(scene);
    }

    public TimedSceneManager(ArrayList<Scene> scenes) {
        setScenes(new ArrayList<Scene>());
        getScenes().addAll(scenes);
    }

    public void setStartTime() {
        startTime = DeltaModUtil.millis();
    }

    public void tick() {
        if (getScenes().isEmpty()) {
            return;
        }
        if ((startTime + interval) < DeltaModUtil.millis()) {
            next();
        }
        current().tick();
    }

    public Scene next() {
        setCurrent(getNext());
        setStartTime();
        return current();
    }

    public void onClick() {

    }

    public void onKey() {

    }
}
