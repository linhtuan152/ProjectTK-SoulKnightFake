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
        this.renderer = new ImageRenderer("resources/image/mp.png",60,60);
        this.boxCollider = new BoxCollider(60,60);
    }

    @Override
    public void run(){
        super.run();
        this.enemyMove.run(this);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
