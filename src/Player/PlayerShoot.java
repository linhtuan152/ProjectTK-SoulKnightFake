package Player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import input.KeyboardInput;

import java.awt.event.KeyEvent;

public class PlayerShoot {
    public FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(5);
    }


    public void run(Player player) {
            if (this.frameCounter.run()) {
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(player.position);
                Vector2D vector2D = new Vector2D(5, 0);
                Vector2D rotate = vector2D.rotate(player.playerMove.angle);
                bulletPlayer.velocity.set(rotate);
                bulletPlayer.run();
                this.frameCounter.reset();
            }
        }


    }