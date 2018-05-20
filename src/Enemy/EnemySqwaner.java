package Enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import java.util.Random;

public class EnemySqwaner extends GameObject {

    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(1500000000);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
            enemy.position.set(new Vector2D(this.random.nextInt(1024),this.random.nextInt(600)));
            this.frameCounter.reset();
        }
    }
}
