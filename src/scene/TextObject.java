package scene;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class TextObject extends GameObject {

    public TextObject() {
        this.renderer = new TextRenderer("YOU LOSE !!", Color.RED, "resources/FiraMono-Bold.ttf", 40);
        this.position.set(350, 200);
    }
}
