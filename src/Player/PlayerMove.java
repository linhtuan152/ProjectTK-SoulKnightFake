package Player;

import base.Vector2D;
import input.KeyInput;
import input.KeyboardInput;
import renderer.AnimationRenderer;

import java.awt.event.KeyEvent;

public class PlayerMove  {
    public Vector2D defaultVelocity = new Vector2D(0,0);
    public Vector2D velocity;
    public double angle = 0.0;

    public PlayerMove() {
        this.velocity = new Vector2D();
    }

    public AnimationRenderer rightanimationRenderer = new AnimationRenderer(true, 5,"resources/image/p1.png","resources/image/p2.png",
            "resources/image/p3.png");
    public AnimationRenderer leftanimationRenderer = new AnimationRenderer(true, 5, "resources/image/t1.png","resources/image/t2.png",
            "resources/image/t3.png");

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
//        if (KeyInput.instance.leftPressed) {
//            this.angle = 180;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.leftanimationRenderer;
//
//        }
        if (KeyboardInput.instance.multiKeyPressed.contains(KeyEvent.VK_LEFT)) {
            int index = KeyboardInput.instance.multiKeyPressed.indexOf(KeyEvent.VK_LEFT);
            KeyboardInput.instance.multiKeyPressed.remove(index);
            this.angle = 180;
            this.velocity.set((new Vector2D(5, 0)).rotate(this.angle));
            player.renderer = this.leftanimationRenderer;
        }

        if (KeyboardInput.instance.multiKeyPressed.contains(KeyEvent.VK_RIGHT)) {
            int index = KeyboardInput.instance.multiKeyPressed.indexOf(KeyEvent.VK_RIGHT);
            KeyboardInput.instance.multiKeyPressed.remove(index);
            this.angle = 0;
            this.velocity.set((new Vector2D(5, 0)).rotate(this.angle));
            player.renderer = this.rightanimationRenderer;
        }

        if (KeyboardInput.instance.multiKeyReleased.contains(KeyEvent.VK_LEFT)) {
            int index = KeyboardInput.instance.multiKeyReleased.indexOf(KeyEvent.VK_LEFT);
            KeyboardInput.instance.multiKeyPressed.remove(index);
            this.angle = 180;
            this.velocity.set(new Vector2D(0,0).rotate(this.angle));
            player.renderer = this.leftanimationRenderer;
        }

        if (KeyboardInput.instance.multiKeyReleased.contains(KeyEvent.VK_RIGHT)) {
            int index = KeyboardInput.instance.multiKeyReleased.indexOf(KeyEvent.VK_RIGHT);
            KeyboardInput.instance.multiKeyPressed.remove(index);
            this.angle = 0;
            this.velocity.set(new Vector2D(0,0).rotate(this.angle));
            player.renderer = this.rightanimationRenderer;
        }



//        if (KeyboardInput.instance.multiKeyPressed.contains(KeyEvent.VK_UP)) {
//            int index = KeyboardInput.instance.multiKeyPressed.indexOf(KeyEvent.VK_UP);
//            KeyboardInput.instance.multiKeyPressed.remove(index);
//        }
//        if (KeyboardInput.instance.multiKeyPressed.contains(KeyEvent.VK_DOWN)) {
//            int index = KeyboardInput.instance.multiKeyPressed.indexOf(KeyEvent.VK_DOWN);
//            KeyboardInput.instance.multiKeyPressed.remove(index);
//        }
//        if (KeyboardInput.instance.getKeyPressed(KeyEvent.VK_LEFT)) {
//            this.angle = 180;
//            this.velocity.set((new Vector2D(5, 0)).rotate(this.angle));
//            player.renderer = this.leftanimationRenderer;
//        }
//        if (KeyboardInput.instance.getKeyReleased(KeyEvent.VK_LEFT)) {
//            this.velocity.set(0, 0);
//        }
//
//        if (KeyboardInput.instance.getKeyPressed(KeyEvent.VK_RIGHT)) {
//            this.angle = 0;
//            this.velocity.set((new Vector2D(5, 0)).rotate(this.angle));
//            player.renderer = this.rightanimationRenderer;
//        }
//        if (KeyboardInput.instance.getKeyReleased(KeyEvent.VK_RIGHT)) {
//            this.velocity.set(0, 0);
//        }
        if (KeyboardInput.instance.getKeyPressed(KeyEvent.VK_UP)) {
            this.angle = -90;
            this.velocity.set((new Vector2D(5, 0)).rotate(this.angle));
            player.renderer = this.rightanimationRenderer;
        }
        if (KeyboardInput.instance.getKeyReleased(KeyEvent.VK_UP)) {
            this.velocity.set(0, 0);
        }

        if (KeyboardInput.instance.getKeyPressed(KeyEvent.VK_DOWN)) {
            this.angle = 90;
            this.velocity.set((new Vector2D(5, 0)).rotate(this.angle));
            player.renderer = this.leftanimationRenderer;
        }
        if (KeyboardInput.instance.getKeyReleased(KeyEvent.VK_DOWN)) {
            this.velocity.set(0, 0);
        }

        player.position.addUp(this.velocity);
//        if (KeyInput.instance.rightPressed) {
//            this.angle = 0;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.rightanimationRenderer;
//        }
//        if (KeyInput.instance.upPressed) {
//            this.angle = -90;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.rightanimationRenderer;
//        }
//        if (KeyInput.instance.downPressed){
//            this.angle = 90;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.leftanimationRenderer;
//        }

//        if (KeyInput.instance.upPressed && KeyInput.instance.rightPressed){
//            this.angle = -45;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.rightanimationRenderer;
//        }
//        if (KeyInput.instance.upPressed && KeyInput.instance.leftPressed){
//            this.angle = -135;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.leftanimationRenderer;
//        }
//        if (KeyInput.instance.downPressed && KeyInput.instance.rightPressed){
//            this.angle = 45;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.rightanimationRenderer;
//        }
//        if (KeyInput.instance.downPressed && KeyInput.instance.leftPressed){
//            this.angle = 135;
//            player.position.addUp(this.velocity.rotate(angle));
//            player.renderer = this.leftanimationRenderer;
//        }

//        if (KeyInput.instance.spacePressed) {
//            player.playerShoot.isPlayerShoot = true;
//        }
//        if (KeyInput.instance.spaceReleased) {
//            player.playerShoot.isPlayerShoot = false;
//        }
//        if (KeyInput.instance.upReleased) {
//            player.position.addUp(defaultVelocity);
//        }

//        this.velocity.set(this.defaultVelocity.rotate(this.angle));
    }
}
