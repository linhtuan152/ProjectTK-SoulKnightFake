package scene;

import Player.Player;
import base.GameObjectManager;
//import game.background.Background;
import Enemy.EnemySqwaner;
//import game.player.Player;
//import game.star.StarSqwaner;

public class GameplayScene  implements Scene {

    private void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(200, 200);
    }

    @Override
    public void init() {
//        GameObjectManager.instance.recycle(Background.class);
        this.setupPlayer();
        GameObjectManager.instance.recycle(EnemySqwaner.class);
//        GameObjectManager.instance.recycle(StarSqwaner.class).createAction();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
