package LogicClasses;

import LogicClasses.Levels.Level;
import LogicClasses.Utilities.Circle;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Circle {

    public PVector velocity = new PVector(0, 0.01f);

    boolean inAir = true;

    Ball(float x, float y, float radius) {
        super(x, y, radius);
    }

    public void update(Level currentLevel) {

        if (currentLevel.getGridState(this.getX(), this.getY() + getRadius()) == 0) {
            inAir = true;
        } else {
            inAir = false;
        }

        velocity.y += inAir ? 0.05f : 0;

        velocity.x *= 0.95f;

        if (currentLevel.getGridState(this.getX() + this.getRadius(), this.getY()) == 1 && velocity.x > 0 ||
                currentLevel.getGridState(this.getX() - this.getRadius(), this.getY()) == 1 && velocity.x < 0) {
            velocity.x *= -0.75f;
        }

        if (currentLevel.getGridState(this.getX(), this.getY() - this.getRadius()) == 1 && velocity.y < 0) {
            velocity.y *= -0.75f;
        }

        position.add(velocity);

        if (currentLevel.getGridState(this.getX(), this.getY() + this.getRadius()) == 1
                && PApplet.abs(velocity.y) > 0) {

            velocity.y = 0;

            this.setY(this.getY() - (this.getY() + this.getRadius()) % 1.0f);

        }

        if(this.getX() - this.getRadius() < 0) {
            this.setX(0 + this.getRadius());
            this.velocity.x *= -0.75f;
        }

        if(this.getX() + this.getRadius() > currentLevel.getWidth()) {
            this.setX(currentLevel.getWidth() - this.getRadius());
            this.velocity.x *= -0.75f;
        }


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

}
