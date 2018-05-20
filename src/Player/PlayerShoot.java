package Player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import input.KeyboardInput;

import java.awt.event.KeyEvent;

public class PlayerShoot {
    public FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(2);
    }


    public void run(Player player) {
        if (KeyboardInput.instance.multiKeyPressed.contains(KeyEvent.VK_SPACE)) {
            //KeyboardInput.instance.multiKeyPressed.removeIf(key -> key == KeyEvent.VK_SPACE);

            if (this.frameCounter.run()) {
                int index = KeyboardInput.instance.multiKeyPressed.indexOf(KeyEvent.VK_SPACE);
                KeyboardInput.instance.multiKeyPressed.remove(index);
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(player.position);
                Vector2D vector2D = new Vector2D(7, 0);
                Vector2D rotate = vector2D.rotate(player.playerMove.angle);
                bulletPlayer.velocity.set(rotate);
                bulletPlayer.run();
                this.frameCounter.reset();
            }
        }


    }

}