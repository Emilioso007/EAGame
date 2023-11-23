package LogicClasses.Utilities;

public class Circle {
    
    private float x, y, radius;

    public Circle(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean contains(float x, float y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= radius;
    }

    public boolean intersects(Circle circle) {
        return Math.sqrt(Math.pow(circle.x - this.x, 2) + Math.pow(circle.y - this.y, 2)) <= circle.radius + this.radius;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y; 
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setRadius(float radius) {
        this.radius = radius; 
    }
    
    public float getRadius() {
        return radius;
    }

}
