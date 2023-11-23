
package LogicClasses.Utilities;

import processing.core.PVector;

public class Circle {
    private PVector position;
    
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

    public float getY() {
        return position.y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}