package LogicClasses;

import LogicClasses.Levels.Level;
import LogicClasses.Utilities.Circle;
import processing.core.PVector;

public class Ball extends Circle{
    
    PVector velocity = new PVector(0, 0);


    Ball(float x, float y, float radius){
        super(x, y, radius);
    }

    public boolean hitGround(Level currentLevel){
        return getY() + getRadius() >= currentLevel.getGroundLevel();
    }

}
