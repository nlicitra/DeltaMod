package scene;

import java.util.ArrayList;

public class SceneManager {
    private ArrayList<Scene> scenes;
    private Scene current;

    public SceneManager() {
        scenes = new ArrayList<Scene>();
    }

    public SceneManager(Scene scene) {
        scenes = new ArrayList<Scene>();
        addScene(scene);
    }

    public SceneManager(ArrayList<Scene> scenes) {
        this.scenes = new ArrayList<Scene>();
        this.scenes.addAll(scenes);
    }

    public void addScene(Scene scene) {
        if (scenes.isEmpty()) {
            current = scene;
        }
        scenes.add(scene);
    }

    public Scene current() {
        return current;
    }

    public Scene next() {
        current = getNext();
        return current();
    }

    public Scene getNext() {
        int index = scenes.indexOf(current());
        if (++index >= scenes.size()) {
            index = 0;
        }
        return scenes.get(index);
    }

    public void tick() {
        current().tick();
    }

    public void onClick() {
        next();
    }

    public void onKey() {
        next();
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }

    public Scene getCurrent() {
        return current;
    }

    public void setCurrent(Scene current) {
        this.current = current;
    }
}
