package Enemy;

import Player.Player;
import base.GameObjectManager;
import base.Vector2D;

public class EnemyMove {

    public Vector2D velocity;

    public EnemyMove() {
        this.velocity = new Vector2D();
    }


    public void run (Enemy enemy) {
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.velocity.set(
                    player
                            .position
                            .subtract(enemy.position)
                            .normalize()
            ).multiply(2);
        } else {
            this.velocity = new Vector2D(2,1);
        }

        enemy.position.addUp(this.velocity);
    }
}
