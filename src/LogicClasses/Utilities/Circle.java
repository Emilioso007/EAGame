
package LogicClasses.Utilities;

import processing.core.PVector;

public class Circle {
    public PVector position;

    private float radius;

    public Circle(float x, float y, float radius) {
        this.position = new PVector(x, y);
        this.radius = radius;
    }

    public boolean contains(float x, float y) {
        float distance = PVector.dist(position, new PVector(x, y));
        return distance <= radius;
    }

    public boolean intersects(Circle circle) {
        float distance = PVector.dist(position, circle.position);
        return distance <= radius + circle.radius;
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }

    public PVector getPosition() {
        return position;
    }

    public float getX() {
        return position.x;
    }

    public void setX(float x) {
        position.x = x;
    }

    public float getY() {
        return position.y;
    }

    public void setY(float y) {
        position.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public boolean intersects(AABB other) {

        float closestX = position.x;
        float closestY = position.y;

        if (position.x < other.getX()) {
            closestX = other.getX();
        } else if (position.x > other.getX() + other.getWidth()) {
            closestX = other.getX() + other.getWidth();
        }

        if (position.y < other.getY()) {
            closestY = other.getY();
        } else if (position.y > other.getY() + other.getHeight()) {
            closestY = other.getY() + other.getHeight();
        }

        float distance = PVector.dist(position, new PVector(closestX, closestY));

        return distance <= radius;

    }

public int intersectsV2(AABB other) {
    float closestX = position.x;
    float closestY = position.y;

    if (position.x < other.getX()) {
        closestX = other.getX();
    } else if (position.x > other.getX() + other.getWidth()) {
        closestX = other.getX() + other.getWidth();
    }

    if (position.y < other.getY()) {
        closestY = other.getY();
    } else if (position.y > other.getY() + other.getHeight()) {
        closestY = other.getY() + other.getHeight();
    }

    float distance = PVector.dist(position, new PVector(closestX, closestY));

    if (distance <= radius) {
        float dx = position.x - closestX;
        float dy = position.y - closestY;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                return 1; // Hit the left side
            } else {
                return 2; // Hit the right side
            }
        } else {
            if (dy > 0) {
                return 3; // Hit the top side
            } else {
                return 4; // Hit the bottom side
            }
        }
    }

    return 0; // No intersection
}

    public int intersectsAdvanced(AABB other) {

        int hitWall = 0;

        if (other.contains(this.getX() + getRadius(), this.getY())) {
            hitWall = 1;
            position.x = (float) Math.ceil(position.x) - getRadius();
        }

        if (other.contains(this.getX() - getRadius(), this.getY())) {
            hitWall = 2;
            position.x = (float) Math.floor(position.x) + getRadius();
        }

        if (other.contains(this.getX(), this.getY() + getRadius())) {
            hitWall = 3;
            position.y = (float) Math.ceil(position.y) - getRadius();
        }

        if (other.contains(this.getX(), this.getY() - getRadius())) {
            hitWall = 4;
            position.y = (float) Math.floor(position.y) + getRadius();
        }

        return hitWall;

    }

}