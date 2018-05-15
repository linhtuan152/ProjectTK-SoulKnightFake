package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyboardInput implements KeyListener {

    public static KeyboardInput instance = new KeyboardInput();

    private List<Boolean> keyPressed;
    private List<Boolean> keyTyped;
    private List<Boolean> keyReleased;

    private int NUMBER_KEY = 256;

    private KeyboardInput() {
        this.keyPressed = new ArrayList<>();
        this.keyTyped = new ArrayList<>();
        this.keyReleased = new ArrayList<>();
        for (int i = 0; i < NUMBER_KEY; i++) {
            this.keyPressed.add(false);
            this.keyTyped.add(false);
            this.keyReleased.add(false);
        }
    }

    public boolean getKeyPressed(int code) {
        return this.keyPressed.get(code);
    }

    public boolean getKeyTyped(int code) {
        return this.keyTyped.get(code);
    }

    public boolean getKeyReleased(int code) {
        return this.keyReleased.get(code);
    }

    public void update() {
        for (int i = 0; i < NUMBER_KEY; i++) {
            this.keyPressed.set(i, false);
            this.keyTyped.set(i, false);
            this.keyReleased.set(i, false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.keyTyped.set(e.getKeyCode(), true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyPressed.set(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyReleased.set(e.getKeyCode(), true);
    }
}