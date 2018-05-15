package Player;


import Enemy.Enemy;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import scene.GameOverScene;
import scene.SceneManager;

public class Player extends GameObject implements PhysicBody, HitObject{

    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player(){
        this.position = new Vector2D();
        this.renderer =new ImageRenderer("resources/image/player.jpg",50,50);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.runHitObject = new RunHitObject(Enemy.class);
        this.boxCollider = new BoxCollider(50,50);
    }

    @Override
    public void run(){
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        SceneManager.instance.changeScene(new GameOverScene());
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
