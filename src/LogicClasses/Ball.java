package LogicClasses;

import LogicClasses.Levels.Level;
import LogicClasses.Utilities.Circle;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Circle {

    PVector velocity = new PVector(0, 0);

    Ball(float x, float y, float radius) {
        super(x, y, radius);
    }

    public void update(Level currentLevel) {
        if (!hitGround(currentLevel)) {
            fall();
        } else {
            velocity.x *= 0.9;
            velocity.y = 0;
            position.y = position.y - getRadius();
        }
        position.add(velocity);

        position.x = PApplet.constrain(position.x, 0, 1280 - 1);
        position.y = PApplet.constrain(position.y, 0, 720 - 1);

    }

    public boolean hitGround(Level currentLevel) {
        return currentLevel.getGridState(this.getX(), getY() + getRadius()) == 1;
    }

    public void fall() {
        velocity.y += 0.1;
    }

}
