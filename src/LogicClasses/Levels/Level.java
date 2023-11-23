package LogicClasses.Levels;

import processing.core.PApplet;
import processing.core.PImage;

public class Level{

    PApplet p;

    PImage image;

    int[][] grid;

    public Level(PApplet p, PImage image) {

        this.p = p;

        this.image = image;

        grid = new int[image.width][image.height];

        calculateGrid();

    }

    public int getGridState(float x, float y) {

        int tempx = (int)PApplet.map(x, 0, p.width, 0, image.width);
        int tempy = (int)PApplet.map(y, 0, p.height, 0, image.height);

        return grid[tempx][tempy];

    }

    private void calculateGrid() {

        for (int i = 0; i < image.width; i++) {
            for (int j = 0; j < image.height; j++) {

                int pixel = image.get(i, j);

                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;

                if (r == 0 && g == 0 && b == 255) { //blue
                    grid[i][j] = 0;
                } else if (r == 0 && g == 255 && b == 0) { //green
                    grid[i][j] = 1;
                } else if (r == 255 && g == 0 && b == 0) { //red
                    grid[i][j] = 2;
                }

            }
        }

    }

}

