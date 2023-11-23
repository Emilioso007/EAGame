package LogicClasses;

import LogicClasses.Levels.*;

public class LevelManager {
    
    Level currentLevel;

    public LevelManager() {

        currentLevel = new Level_1();

    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

}
