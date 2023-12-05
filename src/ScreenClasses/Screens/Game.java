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

        int amountOfWorlds = 4;

        textures = new PImage[4 * amountOfWorlds];

        String worldType;

        for (int i = 0; i < amountOfWorlds; i++) {

            switch (i) {
                case 0:
                    worldType = "Earth";
                    break;
                case 1:
                    worldType = "Moon";
                    break;
                case 2:
                    worldType = "Mars";
                    break;
                case 3:
                    worldType = "Mercury";
                    break;
                default:
                    worldType = "Earth";
                    break;
            }

            textures[0 + i * 4] = p.loadImage("\\Images\\Textures\\" + worldType + "\\sky.png");
            textures[1 + i * 4] = p.loadImage("\\Images\\Textures\\" + worldType + "\\grass.png");
            textures[2 + i * 4] = p.loadImage("\\Images\\Textures\\" + worldType + "\\hole.png");
            textures[3 + i * 4] = p.loadImage("\\Images\\Textures\\" + worldType + "\\dirt.png");

        }

    }

    public void update() {
        gameManager.update();
    }

    public void render() {

        String worldType = gameManager.getLevelManager().getCurrentLevel().getWorldType();

        int worldIndex = 0;

        switch (worldType) {
            case "Earth":
                worldIndex = 0;
                break;
            case "Moon":
                worldIndex = 1;
                break;
            case "Mars":
                worldIndex = 2;
                break;
            case "Mercury":
                worldIndex = 3;
                break;
            default:
                worldIndex = 0;
                break;
        }

        int[][] grid = gameManager.getCurrentLevelGridState();

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

                p.image(textures[value + worldIndex*4], x * 40, y * 40);

            }
        }

        p.fill(255);

        p.ellipseMode(PApplet.RADIUS);
        p.ellipse(gameManager.getBall().getX() * 40, gameManager.getBall().getY() * 40,
                gameManager.getBall().getRadius() * 40,
                gameManager.getBall().getRadius() * 40);

        p.fill(0);
        p.textSize(20);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("x: " + gameManager.getBall().getX() + " y: " + gameManager.getBall().getY() + "\nxSpeed: "
                + gameManager.getBall().getXSpeed() + " ySpeed: " + gameManager.getBall().getYSpeed() + "\nSwings: "
                + gameManager.getGolfClub().getSwings(), 16 * 40, 9 * 40);

    }

}
