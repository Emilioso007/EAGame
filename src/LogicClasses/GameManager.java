package LogicClasses;

import ScreenClasses.ScreenManager;

public class GameManager {
    
    ScreenManager screenManager;

    Ball ball;

    public GameManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
        ball = new Ball(100, screenManager.getP().height / 2, 10);
    }

}
