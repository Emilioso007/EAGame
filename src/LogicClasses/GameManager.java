package LogicClasses;

import LogicClasses.Utilities.MH;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class GameManager {

    private PApplet p;

    LevelManager levelManager;

    Ball ball;

    GolfClub golfClub;

    public GameManager() {
        this.p = ScreenManager.p;

        levelManager = new LevelManager();

        ball = new Ball(2.0f, 2.0f, 0.25f);

        golfClub = new GolfClub(ball);

    }

    public void update() {

        float levelGravity = 0.0f;

        switch (levelManager.getCurrentLevel().getWorldType()) {
            case "Earth":
                levelGravity = 9.82f;
                break;
            case "Moon":
                levelGravity = 1.62f;
                break;
            case "Mars":
                levelGravity = 3.711f;
                break;
            case "Mercury":
                levelGravity = 3.7f;
                break;
            default:
                levelGravity = 9.82f;
                break;
        }

        float gravity = levelGravity * 0.01f;

        PVector gravityVector = new PVector(0, gravity).mult(ball.getMass());

        ball.addAcceleration(gravityVector);

        if (MH.leftPressed && !ball.isMoving()) {

            float mouseX = MH.mouseX / 40.0f;

            float mouseY = MH.mouseY / 40.0f;

            float angle = (float) Math.atan2(mouseY - ball.getY(),
                    mouseX - ball.getX());

            float power = PApplet.constrain((float) Math.sqrt(Math.pow(mouseX - ball.getX(), 2)
                    + Math.pow(mouseY - ball.getY(), 2)) * 0.010f, 0, 1);

            golfClub.swing(angle, power);

        }

        for (int i = 0; i < 10; i++) {

            ball.update(levelManager.getCurrentLevel());

            if (ball.hitGoal(levelManager.getCurrentLevel())) {
                levelManager.nextLevel();
                ball = new Ball(2.0f, 2.0f, 0.25f);
                golfClub.setBall(ball);
            }

        }

    }

    public Ball getBall() {
        return ball;
    }

    public GolfClub getGolfClub() {
        return golfClub;
    }

    public PImage getCurrentLevelImage() {
        return levelManager.getCurrentLevel().getImage();
    }

    public int[][] getCurrentLevelGridState() {
        return levelManager.getCurrentLevel().getGridState();
    }

    public int getCurrentLevelIndex() {
        return levelManager.getCurrentLevelIndex();
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

}
