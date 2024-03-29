package LogicClasses;

import LogicClasses.Levels.*;
import ScreenClasses.ScreenManager;
import ScreenClasses.Screens.EndScreen;
import processing.core.PApplet;
import processing.core.PImage;

public class LevelManager {

    private PApplet p;

    public Level currentLevel;

    int currentLevelIndex = 0;

    PImage[] levelImages = new PImage[9];

    public LevelManager() {

        this.p = ScreenManager.p;

        for (int i = 0; i < levelImages.length; i++) {
            levelImages[i] = p.loadImage("\\Images\\Levels\\level_" + (i) + ".png");
        }

        currentLevel = new Level(levelImages[currentLevelIndex]);

    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void nextLevel() {
        currentLevelIndex++;
        try{
        currentLevel = new Level(levelImages[currentLevelIndex]);
        } catch(Exception e){
            ScreenManager.changeScreen(new EndScreen());
        }
    }

}
