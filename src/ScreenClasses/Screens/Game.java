package ScreenClasses.Screens;

import LogicClasses.GameManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PImage;

public class Game extends Screen {

    GameManager gameManager;

    PApplet p;

    PImage[] textures;

    public Game(ScreenManager screenManager) {

        gameManager = new GameManager(screenManager);

        this.p = screenManager.getP();

        textures = new PImage[4];

        textures[0] = p.loadImage("\\Images\\Textures\\sky.png");
        textures[1] = p.loadImage("\\Images\\Textures\\grass.png");
        textures[2] = p.loadImage("\\Images\\Textures\\hole.png");
        textures[3] = p.loadImage("\\Images\\Textures\\dirt.png");

    }

    public void update() {
        gameManager.update();
    }

    public void render() {

        int[][] grid = gameManager.getCurrentLevelGrid();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {

                int value = grid[x][y];
                int valueAbove = 0;
                if (y > 0) {
                    valueAbove = grid[x][y - 1];
                }

                if (value == 1 && (valueAbove == 1 || valueAbove == 2)) {
                    value = 3;
                }

                p.image(textures[value], x * 40, y * 40);

            }
        }

        p.fill(255);

        p.ellipseMode(PApplet.RADIUS);
        p.ellipse(gameManager.getBall().getX() * 40, gameManager.getBall().getY() * 40,
                gameManager.getBall().getRadius() * 40,
                gameManager.getBall().getRadius() * 40);

    }

}
