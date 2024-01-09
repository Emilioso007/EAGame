package LogicClasses;

import LogicClasses.Utilities.AABB;
import LogicClasses.Utilities.Circle;
import LogicClasses.Utilities.Functions;
import LogicClasses.Utilities.MouseHandler;
import processing.core.PVector;

public class Ball extends Circle {

    public PVector velocity = new PVector(0, 0);
    public PVector acceleration = new PVector(0, 0);

    float mass = 0.5f;

    Ball(float x, float y, float radius) {
        super(x, y, radius);
    }

    public void update(Level currentLevel) {

        // position = new PVector(MouseHandler.mouseX / 40.0f, MouseHandler.mouseY / 40.0f);

        velocity.add(acceleration);
        acceleration.mult(0);

        for (int arbitrary = 0; arbitrary < 100; arbitrary++) {

            position.add(velocity.copy().mult(0.01f));

            Cell[] cells = currentLevel.getGrid1D();

            for (int i = 0; i < cells.length; i++) {
                if (cells[i].state != 0 && Functions.intersects(this, cells[i])) {

                    // if ball above cell, move ball to top of cell, and reverse y velocity
                    if (position.y - radius < cells[i].y) {
                        position.y = cells[i].y - radius;
                        velocity.y *= -0.5f;
                    } else

                    // if ball below cell, move ball to bottom of cell, and reverse y velocity
                    if (position.y + radius > cells[i].y + cells[i].height / 2) {
                        position.y = cells[i].y + cells[i].height / 2 + radius;
                        velocity.y *= -0.5f;
                    } else

                    // if ball left of cell, move ball to left of cell, and reverse x velocity
                    if (position.x - radius < cells[i].x) {
                        position.x = cells[i].x - radius;
                        velocity.x *= -0.5f;
                    } else

                    // if ball right of cell, move ball to right of cell, and reverse x velocity
                    if (position.x + radius > cells[i].x + cells[i].width / 2) {
                        position.x = cells[i].x + cells[i].width / 2 + radius;
                        velocity.x *= -0.5f;
                    }


                }
            }
        }
    }

    public float getXSpeed() {
        return velocity.x;
    }

    public float getYSpeed() {
        return velocity.y;
    }

    public boolean hitGoal(Level currentLevel) {
        return currentLevel.getGridState(this.position.x, this.position.y + this.radius) == 2;
    }

    public void addAcceleration(PVector acceleration) {
        this.acceleration.add(acceleration);
    }

    public float getMass() {
        return mass;
    }

}
