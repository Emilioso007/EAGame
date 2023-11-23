package LogicClasses;

import ScreenClasses.ScreenManager;
import processing.core.PImage;

public class GameManager {
    
    ScreenManager screenManager;

    LevelManager levelManager;

    Ball ball;

    public GameManager(ScreenManager screenManager) {
        this.screenManager = screenManager;

        levelManager = new LevelManager(this.screenManager.getP());

        ball = new Ball(800, screenManager.getP().height / 2, 16);
    }

    public void update() {
        if(!ball.hitGround(levelManager.getCurrentLevel())){
            ball.fall();
        }
    }

    public Ball getBall() {
        return ball;
    }

    public PImage getCurrentLevelImage() {
        return levelManager.getCurrentLevel().getImage();
    }

    public int[][] getCurrentLevelGrid() {
        return levelManager.getCurrentLevel().getGrid();
    }

}
