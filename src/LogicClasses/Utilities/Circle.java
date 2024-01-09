
package LogicClasses.Utilities;

import processing.core.PVector;

public class Circle {
    public PVector position;

    public float radius;

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

}