package LogicClasses;

import LogicClasses.Levels.Level;
import LogicClasses.Utilities.Circle;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Circle {

    PVector velocity = new PVector(0, 0);

    boolean onGround = false;

    Ball(float x, float y, float radius) {
        super(x, y, radius);
    }

    public void update(Level currentLevel) {

        if (hitGround(currentLevel) && velocity.y > 0 ) {
            onGround = true;
        } else {
            onGround = false;
        }

        if (onGround) {
            velocity.y = 0;
        } else {
            fall();
        }

        velocity.x *= 0.9;

        position.add(velocity);    
    
        position.x = PApplet.constrain(position.x, 0+getRadius(), 32-getRadius());
        position.y = PApplet.constrain(position.y, 0+getRadius(), 18-getRadius());

    }

    public boolean hitGround(Level currentLevel) {
        return currentLevel.getGridState(this.getX(), getY() + getRadius()) == 1;
    }

    public void fall() {
        velocity.y += 0.1;
    }

}
