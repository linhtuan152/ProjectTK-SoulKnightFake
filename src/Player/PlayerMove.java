package Player;

import base.Vector2D;
import input.KeyInput;

public class PlayerMove  {
    public Vector2D defaultVelocity = new Vector2D(0,0);
    public Vector2D velocity;
    public double angle = 0.0;

    public PlayerMove() {
        this.velocity = new Vector2D(5,0);
    }

    public void run(Player player){
        this.handleEventKeyboard(player);
        this.checkPlayerMove(player);
    }

    private void handleEventKeyboard(Player player){
        if (player.position.x >= 995) {
            KeyInput.instance.rightPressed = false;
        }
        if (player.position.x <= 20) {
            KeyInput.instance.leftPressed = false;
        }
        if (player.position.y > 535) {
            KeyInput.instance.downPressed = false;
        }
        if (player.position.y < 20) {
            KeyInput.instance.upPressed = false;
        }
    }

    private void checkPlayerMove(Player player){
        if (KeyInput.instance.leftPressed) {
            this.angle = 180;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.rightPressed) {
            this.angle = 0;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.upPressed) {
            this.angle = -90;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.downPressed){
            this.angle = 90;
            player.position.addUp(this.velocity.rotate(angle));
        }

        if (KeyInput.instance.upPressed && KeyInput.instance.rightPressed){
            this.angle = -45;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.upPressed && KeyInput.instance.leftPressed){
            this.angle = -135;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.downPressed && KeyInput.instance.rightPressed){
            this.angle = 45;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.downPressed && KeyInput.instance.leftPressed){
            this.angle = 135;
            player.position.addUp(this.velocity.rotate(angle));
        }
        if (KeyInput.instance.spacePressed) {
            player.playerShoot.isPlayerShoot = true;
        }
        if (KeyInput.instance.spaceReleased) {
            player.playerShoot.isPlayerShoot = false;
        }
//        if (KeyInput.instance.upReleased) {
//            player.position.addUp(defaultVelocity);
//        }

//        this.velocity.set(this.defaultVelocity.rotate(this.angle));
    }
}
