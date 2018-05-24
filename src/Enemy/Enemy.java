package Enemy;

import base.GameObject;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody, HitObject{

    public EnemyMove enemyMove;
    public BoxCollider boxCollider;
//    public AnimationRenderer explodeAnimationRenderer = new AnimationRenderer(false,10,
//            "resources/image/explode1.png","resources/image/explode2.png",
//            "resources/image/explode3.png","resources/image/explode4.png",
//            "resources/image/explode5.png","resources/image/explode6.png");


    public Enemy() {
        this.enemyMove = new EnemyMove();
        this.renderer = new ImageRenderer("resources/image/mp.png",30,30);
        this.boxCollider = new BoxCollider(30,30);
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

    @Override
    public boolean isActive() {
        return false;
    }
}
