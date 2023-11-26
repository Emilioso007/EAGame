package LogicClasses;

import LogicClasses.Levels.Level;
import LogicClasses.Utilities.Circle;
import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends Circle {

    public PVector velocity = new PVector(0, 0);

    boolean inAir = false;

    Ball(float x, float y, float radius) {
        super(x, y, radius);
    }

    public void update(Level currentLevel) {
        
        inAir = false;

        if (PApplet.abs(velocity.y) > 0.1) {
            inAir = true;
        }

        for(int i = 0; i < currentLevel.getGrid().length; i++) {
            for(int j = 0; j < currentLevel.getGrid()[0].length; j++) {
                if(this.intersects(currentLevel.getGrid()[i][j])) {
                    if(currentLevel.getGridState(i, j) == 1) {
                        velocity.x = 0;
                        velocity.y = 0;
                        position.x = i;
                        position.y = j;
                    }
                }
            }
        }

        if (inAir) {
            velocity.y += 0.001;
        }

        position.add(velocity);

        checkGoal(currentLevel);

    }

    public boolean checkGoal(Level currentLevel) {

        if (currentLevel.getGridState(this.getX(), this.getY()) == 2) {
            return true;
        }

        return false;

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
        return currentLevel.getGridState(this.getX(), this.getY()) == 2;
    }

}
