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

        ball = new Ball(2.0f, 2.0f, 0.5f);

        golfClub = new GolfClub(ball);

    }

    public void update() {

        if (screenManager.getP().mousePressed) {

            float mouseX = screenManager.getP().mouseX/40.0f;

            float mouseY = screenManager.getP().mouseY/40.0f;

            float angle = (float) Math.atan2(mouseY - ball.getY(),
                    mouseX - ball.getX());

            float power = (float) Math.sqrt(Math.pow(mouseX - ball.getX(), 2)
                    + Math.pow(mouseY - ball.getY(), 2)) * 0.1f;

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
