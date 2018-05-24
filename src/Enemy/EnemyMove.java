package Enemy;

import Player.Player;
import base.GameObjectManager;
import base.Vector2D;
import renderer.AnimationRenderer;

public class EnemyMove {

    public Vector2D velocity;
    public Player player;

    public EnemyMove() {
        this.velocity = new Vector2D();
    }


    public AnimationRenderer rightAnimationRenderer = new AnimationRenderer(true,5,"resources/image/mp.png");

    public AnimationRenderer leftAnimationRenderer = new AnimationRenderer(true,5,"resources/image/mt.png");



    public void run (Enemy enemy) {
        Player player = GameObjectManager.instance.findPlayer();

        if (player != null) {
            this.velocity.set(
                    player
                            .position
                            .subtract(enemy.position)
                            .normalize()
            ).multiply(2);
            if(player.position.x <= enemy.position.x) {
                enemy.renderer = this.leftAnimationRenderer;
            } else enemy.renderer = this.rightAnimationRenderer;
        } else {
            this.velocity = new Vector2D(2,1);
        }

        enemy.position.addUp(this.velocity);
    }
}
