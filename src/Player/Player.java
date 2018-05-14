package Player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Player extends GameObject{
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player(){
        this.position = new Vector2D();
        this.renderer =new ImageRenderer("resources/image/player.jpg",50,50);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run(){
        this.playerMove.run(this);
        this.playerShoot.run(this);
    }
}
