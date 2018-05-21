package Enemy;

import base.FrameCounter;
import base.GameObject;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

import java.util.Random;

public class Enemy extends GameObject implements PhysicBody, HitObject{

    public EnemyMove enemyMove;
    public BoxCollider boxCollider;
    public FrameCounter frameCounter;
    public AnimationRenderer explodeAnimationRenderer = new AnimationRenderer(false,10,
            "resources/image/explode1.png","resources/image/explode2.png",
            "resources/image/explode3.png","resources/image/explode4.png",
            "resources/image/explode5.png","resources/image/explode6.png");


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
        this.renderer = this.explodeAnimationRenderer;
        this.isAlive = false;

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
