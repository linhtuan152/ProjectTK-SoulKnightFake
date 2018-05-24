package base;

import action.Action;
import game.ViewPort;
import physic.Physic;
import physic.PhysicBody;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public boolean isAlive = true;
    private List<Action> actions;
    public Vector2D screenPosition;
    public ViewPort viewPort;

    public GameObject() {
        this.position = new Vector2D();
        this.actions = new ArrayList<>();
        this.viewPort = new ViewPort();

    }

    public void run() {
        this.actions.removeIf(action -> action.run(this));
    }

    public void render(Graphics graphics, ViewPort viewPort) {
        if (this.renderer == null) return;
        this.renderer.render(graphics, viewPort.translate(this.position));

//        if (this.renderer == null) return;
//            this.renderer.render(graphics, viewPort.translate(this.screenPosition));
        }


    public void addAction(Action action) {
        this.actions.add(action);
    }

//    public static void add(GameObject gameObject) {
//        boolean duplicate = false;
//        for (GameObject g : gameObjects) {
//            if (g == gameObject) {
//                duplicate = true;
//            }
//        }
//        if (!duplicate) {
//            newGameObjects.add(gameObject);
//            if (gameObject instanceof PhysicBody) {
//                Physic.add((PhysicBody) gameObject);
//            }
//        } else {
//            System.out.println("Duplicate objects");
//        }
//    }

}


