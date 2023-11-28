package LogicClasses;

import LogicClasses.Levels.*;
import processing.core.PApplet;
import processing.core.PImage;

public class LevelManager {

    PApplet p;

    Level currentLevel;

    int currentLevelIndex = 0;

    PImage[] levelImages = new PImage[7];

    public LevelManager(PApplet p) {

        this.p = p;

        for (int i = 0; i < levelImages.length; i++) {
            levelImages[i] = p.loadImage("\\Images\\Levels\\level_" + (i) + ".png");
        }

        currentLevel = new Level(p, levelImages[currentLevelIndex]);

    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void nextLevel() {
        currentLevelIndex++;
        currentLevel = new Level(p, levelImages[currentLevelIndex]);
    }

}
