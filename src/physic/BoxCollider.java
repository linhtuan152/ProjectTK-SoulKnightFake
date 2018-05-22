package physic;

import base.GameObject;
import base.Vector2D;
import base.Mathx;
import java.awt.*;

public class BoxCollider extends GameObject {

    public Vector2D position;
    public int width;
    public int height;

    public BoxCollider(int width, int height) {
        super();
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public BoxCollider() {
        this(0, 0);
    }

    public float left() {
        return this.screenPosition.x - width / 2;
    }

    public float right() {
        return this.screenPosition.x + width / 2;
    }

    public float top() {
        return this.screenPosition.y - height / 2;
    }

    public float bottom() {
        return this.screenPosition.y + height / 2;
    }

    public boolean collideWith(float top, float bottom, float left, float right) {
        boolean xOverlap = Mathx.inRange(left, this.left(), this.right())
                || Mathx.inRange(this.left(), left, right);

        boolean yOverlap = Mathx.inRange(top, this.top(), this.bottom())
                || Mathx.inRange(this.top(), top, bottom);

        return xOverlap && yOverlap;
    }

    public boolean contains(Vector2D position) {
        return Mathx.inRange(position.x, left(), right()) &&
                Mathx.inRange(position.y, top(), bottom());
    }

    public boolean collideWith(BoxCollider other) {
        return collideWith(other.top(), other.bottom(), other.left(), other.right());
    }

    public boolean checkCollider(BoxCollider other) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, this.width, this.height);
        Rectangle r2 = new Rectangle((int) other.position.x, (int) other.position.y, other.width, other.height);
        return r1.intersects(r2);
    }
    @Override
    public String toString() {
        return "BoxCollider{" +
                "width=" + width +
                ", height=" + height +
                ", screenPosition=" + screenPosition +
                '}';
    }
}
