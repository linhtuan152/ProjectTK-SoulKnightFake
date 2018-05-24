package scene;

import Player.Player;
import base.GameObjectManager;
//import game.background.Background;
import Enemy.EnemySqwaner;
import javafx.scene.layout.Background;
//import game.player.Player;
//import game.star.StarSqwaner;

public class GameplayScene  implements Scene {

    public void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(200, 300);
    }

    @Override
    public void init() {
        GameObjectManager.instance.recycle(background.Background.class);
        this.setupPlayer();
        GameObjectManager.instance.recycle(EnemySqwaner.class);
//        GameObjectManager.instance.recycle(StarSqwaner.class).createAction();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
