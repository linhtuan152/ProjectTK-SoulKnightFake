import Player.Player;
import base.GameObject;
import base.GameObjectManager;
import input.KeyInput;
import input.KeyboardInput;
import map.Map;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;
    private Player player;

    public GameWindow() {
        // set size cho window
        this.setSize(1024, 600);
        this.setupGameCanvas();
        this.eventKeyboard();
        this.windowEvent();
        this.addPlatforms();
//        this.addplayer();
        this.setVisible(true);

    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.player = new Player();
        this.add(this.gameCanvas);
    }

    private void eventKeyboard() {
        this.addKeyListener(KeyboardInput.instance);
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    private void addPlatforms() {
        Map map = Map.load("resources/Map/MAP TLU.json");
        map.generate();
    }
//    private void addplayer(){
//        player = new Player();
//        player.position.set(120, 100);
//        GameObjectManager.instance.add(player);
//    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }
}
