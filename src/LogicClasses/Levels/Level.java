package LogicClasses.Levels;

import LogicClasses.Utilities.AABB;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PImage;

public class Level {

    private PApplet p;

    public PImage image;

    public AABB[][] grid;

    public int[][] gridState;

    public String worldType;

    public Level(PImage image) {
        this.p = ScreenManager.p;

        this.image = image;

        grid = new AABB[image.width][image.height];
        gridState = new int[image.width][image.height];

        calculateGrid();

    }

    public int getGridState(float x, float y) {

        int tempx = (int) PApplet.constrain(x, 0, image.width - 1);
        int tempy = (int) PApplet.constrain(y, 0, image.height - 1);

        return gridState[tempx][tempy];

    }

    private void calculateGrid() {

        int pixelZero = image.get(0, 0) >> 16 & 0xFF;

        switch (pixelZero) {
            case 1:
                worldType = "Earth";
                break;

            case 2:
                worldType = "Moon";
                break;

            case 3:
                worldType = "Mars";
                break;

            case 4:
                worldType = "Mercury";
                break;
            default:
                worldType = "Earth";
                break;
        }

        for (int i = 0; i < image.width; i++) {
            for (int j = 0; j < image.height; j++) {

                int pixel = image.get(i, j);

                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;

                if (r != 255 && g != 255 && b == 255) { // blue
                    gridState[i][j] = 0;
                } else if (r != 255 && g == 255 && b != 255) { // green
                    gridState[i][j] = 1;
                } else if (r == 255 && g != 255 && b != 255) { // red
                    gridState[i][j] = 2;
                }

                grid[i][j] = new AABB(i, j, 1, 1);

            }
        }

    }

    public PImage getImage() {
        return image.copy();
    }

    public int[][] getGridState() {
        return gridState;
    }

    public AABB[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return image.width;
    }

    public int getHeight() {
        return image.height;
    }

    public String getWorldType() {
        return worldType;
    }

}
