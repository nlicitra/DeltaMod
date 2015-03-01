package scene;

import primitive.DynamicPrimitive;

import java.util.ArrayList;
import java.util.Iterator;

public class Scene {
    private ArrayList<SceneObject> objects;

    public Scene() {
        objects = new ArrayList();
    }

    public Scene(DynamicPrimitive obj) {
        objects = new ArrayList();
        this.add(obj);
    }

    public Scene(ArrayList<DynamicPrimitive> objs) {
        objects = new ArrayList();
        for (DynamicPrimitive dp : objs) {
            this.add(dp);
        }
    }

    public void add(DynamicPrimitive primitive) {
        objects.add(new SceneObject(primitive));
    }

    // I might not even need this
    //  void add(ArrayList<DynamicPrimitive> objs) {
    //    objects.addAll(objs);
    //  }

    public void tick() {
        removeExpired();
        update();
        render();
    }

    public void update() {
        for (SceneObject obj : objects) {
            obj.update();
        }
    }

    public void render() {
        for (SceneObject obj : objects) {
            obj.render();
        }
    }

    public void removeExpired() {
        Iterator<SceneObject> itr = objects.iterator();
        while (itr.hasNext ()) {
            SceneObject obj = itr.next();
            if (obj.isExpired()) {
                itr.remove();
            }
        }
    }

    public SceneObject removeLastPrimitive() {
        if (!objects.isEmpty()) {
            return objects.remove(objects.size()-1);
        }
        return null;
    }

    public void refresh() {
        //background(color(0, 0, 0));
    }

    public void reset() {
        objects.clear();
    }
}
