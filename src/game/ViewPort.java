package game;

import Player.Player;
import base.GameObject;
import base.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ViewPort {

    private Vector2D position;
    private Vector2D followOffset;

    public ViewPort(){
        position = Vector2D.ZERO.clone();
        followOffset = Vector2D.ZERO.clone();
    }

    public void follow(GameObject gameObject, Vector2D position){
      position = gameObject.position.add(followOffset);
    }

    public Vector2D translate(Vector2D position){
       return position.subtract(this.position);
    }

    public Vector2D getFollowOffset() {
        return followOffset;
    }
}
