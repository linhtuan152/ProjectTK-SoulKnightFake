package Player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;

public class PlayerShoot {
    public boolean isPlayerShoot = false;
    public FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(10);
    }


    public void run(Player player){
        if (this.isPlayerShoot){
            if (this.frameCounter.run()){
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(player.position);
                Vector2D vector2D = new Vector2D(7, 0);
                Vector2D rotate = vector2D.rotate(player.playerMove.angle);
                bulletPlayer.velocity.set(rotate);
                bulletPlayer.run();
            }
        } else {
            this.frameCounter.reset();
            }
        }
    }

