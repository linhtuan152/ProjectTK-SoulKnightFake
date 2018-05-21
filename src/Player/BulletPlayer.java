package Player;

import Enemy.Enemy;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody, HitObject{

    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public Vector2D velocity;


    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/image/bullet.png",7,7);
        this.boxCollider = new BoxCollider(7,7);
        this.runHitObject = new RunHitObject(Enemy.class);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.runHitObject.run(this);
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
