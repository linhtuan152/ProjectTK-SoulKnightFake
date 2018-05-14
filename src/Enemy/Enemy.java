package Enemy;

import base.GameObject;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.util.Random;

public class Enemy extends GameObject implements PhysicBody, HitObject{

    public EnemyMove enemyMove;
    public BoxCollider boxCollider;

    public Enemy() {
        this.enemyMove = new EnemyMove();
        this.renderer = new ImageRenderer("resources/image/monster-512.png",50,50);
        this.boxCollider = new BoxCollider(60,60);
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
