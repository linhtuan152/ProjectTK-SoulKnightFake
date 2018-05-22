package base;


import game.ViewPort;
import physic.BoxCollider;
import physic.Physic;
import physic.PhysicBody;

import Player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        //this.tempList.add(gameObject);
        boolean duplicate = !list.stream()
                .filter(object -> object == gameObject)
                .collect(Collectors.toList())
                .isEmpty();
        if (!duplicate) {
            tempList.add(gameObject);
            if (gameObject instanceof PhysicBody) {
                Physic.add((PhysicBody) gameObject);
            }
        }
    }

    public void runAll() {
        this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics, ViewPort viewPort) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics, viewPort));
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T gameObject = (T) this.list
                .stream()
                .filter(object -> !object.isAlive)
                .filter(object -> cls.isInstance(object))
                .findFirst()
                .orElse(null);
        if (gameObject != null) {
            gameObject.isAlive = true;
        } else {
            try {
                gameObject = cls.newInstance();
                this.tempList.add(gameObject);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gameObject;
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> gameObject.isAlive)
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T checkCollision(BoxCollider boxCollide, Class<T> cls) {
        return (T) this.list
                .stream()
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof PhysicBody)
                .filter(gameObject -> {
                    BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
                    return boxCollide.checkCollider(other);
                })
                .findFirst()
                .orElse(null);
    }

    public void clear(){
        this.list.clear();
        this.tempList.clear();
    }
}
