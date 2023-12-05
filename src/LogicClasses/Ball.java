package LogicClasses;

import LogicClasses.Levels.Level;
import LogicClasses.Utilities.Circle;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Circle {

    public PVector velocity = new PVector(0, 0);
    public PVector acceleration = new PVector(0, 0);

    float mass = 0.5f;

    boolean inAir = true;

    Ball(float x, float y, float radius) {
        super(x, y, radius);
    }

    public void update(Level currentLevel) {

        acceleration.mult(0.1f);

        velocity.add(acceleration);
        

        for (int i = 0; i < 10; i++) {

            position.add(velocity);

            //check if in air
            if (currentLevel.getGridState(this.getX(), this.getY() + getRadius()) == 0) {
                inAir = true;
            } else {
                inAir = false;
            }

            // velocity.x *= 0.95f;

            //check for collision with block walls
            if (currentLevel.getGridState(this.getX() + this.getRadius(), this.getY()) == 1 && velocity.x > 0 ||
                    currentLevel.getGridState(this.getX() - this.getRadius(), this.getY()) == 1 && velocity.x < 0) {
                velocity.x *= -0.75f;
            }

            //check for collision with block ceiling
            if (currentLevel.getGridState(this.getX(), this.getY() - this.getRadius()) == 1 && velocity.y < 0) {
                velocity.y *= -0.75f;
            }

            //check for collision with ground
            if (currentLevel.getGridState(this.getX(), this.getY() + this.getRadius()) == 1
                    && PApplet.abs(velocity.y) > 0) {
                velocity.y = 0;
                this.setY(this.getY() - (this.getY() + this.getRadius()) % 1.0f);
            }

            //bounce left wall
            if (this.getX() - this.getRadius() < 0) {
                this.setX(0 + this.getRadius());
                this.velocity.x *= -0.75f;
            }

            //bounce right wall
            if (this.getX() + this.getRadius() > currentLevel.getWidth()) {
                this.setX(currentLevel.getWidth() - this.getRadius());
                this.velocity.x *= -0.75f;
            }

        }

        acceleration.mult(0);

    }

    public boolean isInAir() {
        return inAir;
    }

    public float getXSpeed() {
        return velocity.x;
    }

    public float getYSpeed() {
        return velocity.y;
    }

    public boolean hitGoal(Level currentLevel) {
        return currentLevel.getGridState(this.getX(), this.getY() + getRadius() + 0.5f) == 2;
    }

    public void addAcceleration(PVector acceleration) {
        this.acceleration.add(acceleration);
    }

    public float getMass() {
        return mass;
    }

}
