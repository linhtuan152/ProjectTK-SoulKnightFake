package scene;

public class SceneManager {

    public static SceneManager instance = new SceneManager();
    private SceneManager(){}

    private Scene currentScene;
    private Scene nextScene;

    public void changeScene(Scene scene){
        this.nextScene = scene;
    };

    public void performChangeSceneIfNeeded(){
        if (this.nextScene != null){
            if (this.currentScene != null){
                this.currentScene.deinit();
            }
            this.nextScene.init();
            this.currentScene = this.nextScene;
            this.nextScene = null;
        }

    }
}
