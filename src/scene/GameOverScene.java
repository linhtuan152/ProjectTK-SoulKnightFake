package scene;

import base.GameObjectManager;
//import game.background.Background;
//import game.star.StarSqwaner;

public class GameOverScene implements Scene {


    @Override
    public void init() {
//        GameObjectManager.instance.recycle(Background.class);
//        GameObjectManager.instance.recycle(StarSqwaner.class).createAction();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
