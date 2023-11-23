package LogicClasses;

import ScreenClasses.ScreenManager;
import processing.core.PImage;

public class GameManager {

    ScreenManager screenManager;

    LevelManager levelManager;

    Ball ball;

    GolfClub golfClub;

    public GameManager(ScreenManager screenManager) {
        this.screenManager = screenManager;

        levelManager = new LevelManager(this.screenManager.getP());

        ball = new Ball(100, screenManager.getP().height / 2, 16);

        golfClub = new GolfClub(ball);

    }

    public void update() {

        if (screenManager.getP().mousePressed) {

            float angle = (float) Math.atan2(screenManager.getP().mouseY - ball.getY(),
                    screenManager.getP().mouseX - ball.getX());

            float power = (float) Math.sqrt(Math.pow(screenManager.getP().mouseX - ball.getX(), 2)
                    + Math.pow(screenManager.getP().mouseY - ball.getY(), 2)) * 0.1f;

            golfClub.swing(angle, power);

        }

        ball.update(levelManager.getCurrentLevel());

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
