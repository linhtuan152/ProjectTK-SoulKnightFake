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
import scene.GameOverScene;
import scene.GameplayScene;
import scene.SceneManager;

import javax.sound.sampled.Clip;

public class Player extends GameObject implements PhysicBody, HitObject{

    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;


//    public AnimationRenderer explodeAnimationRenderer = new AnimationRenderer(false,10,
//            "resources/image/explode1.png","resources/image/explode2.png",
//            "resources/image/explode3.png","resources/image/explode4.png",
//            "resources/image/explode5.png","resources/image/explode6.png");



    public Player(){
        this.position = new Vector2D();
        this.renderer = new ImageRenderer("resources/image/p1.png",30,30);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.runHitObject = new RunHitObject(Enemy.class);
        this.boxCollider = new BoxCollider(30,30);
    }

    @Override
    public void run(){
        this.playerShoot.run(this);
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
//        this.renderer = this.explodeAnimationRenderer;
        this.isAlive = false;
//        SceneManager.instance.changeScene(new GameOverScene());

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
