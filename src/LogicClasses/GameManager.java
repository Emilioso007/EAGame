package LogicClasses;

import LogicClasses.Levels.Level;
import ScreenClasses.ScreenManager;

public class GameManager {
    
    ScreenManager screenManager;

    LevelManager levelManager;

    Ball ball;

    public GameManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
        ball = new Ball(100, screenManager.getP().height / 2, 16);
    }

    public void update() {
        if(!ball.hitGround(levelManager.getCurrentLevel())){
            ball.fall();
        }
    }

    public Ball getBall() {
        return ball;
    }

}
