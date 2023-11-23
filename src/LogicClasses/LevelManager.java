package LogicClasses;

import LogicClasses.Levels.*;
import processing.core.PApplet;

public class LevelManager {

    PApplet p;
    
    Level currentLevel;

    public LevelManager(PApplet p) {

        this.p = p;

        currentLevel = new Level_1(this.p);

    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

}
