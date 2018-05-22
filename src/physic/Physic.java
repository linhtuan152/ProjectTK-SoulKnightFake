package physic;

import base.Vector2D;

import java.util.Vector;

public class Physic {
    private static Vector<PhysicBody> bodies = new Vector<>();

    public static void add(PhysicBody body) {
        bodies.add(body);
    }

    // Generics
    public static <T extends PhysicBody> T bodyInRect(BoxCollider boxCollider, Class<T> classz) {
        for(PhysicBody body: bodies) {
            if (body.isActive() && body.getBoxCollider().collideWith(boxCollider)) {
                if (body.getClass() == classz)
                    return (T) body;
            }
        }

        return null;
    }

    public static <T extends PhysicBody> T bodyAtPoint(Vector2D position, Class<T> classz) {
        for(PhysicBody body: bodies) {
            if (body.isActive() && body.getBoxCollider().contains(position)) {
                if (body.getClass() == classz)
                    return (T) body;
            }
        }

        return null;
    }

    public static <T extends PhysicBody> T bodyInRect(Vector2D position, float width, float height, Class<T> classz) {
        float left = position.x - width / 2;
        float right = position.x + width / 2;
        float top = position.y - height / 2;
        float bottom = position.y + height / 2;

        for(PhysicBody body: bodies) {
            if (body.isActive() && body.getBoxCollider().collideWith(top, bottom, left, right)) {
                if (body.getClass() == classz)
                    return (T) body;
            }
        }

        return null;
    }



    public static void clear() {
        bodies.clear();
    }
}
