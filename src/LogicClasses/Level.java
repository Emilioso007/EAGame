package LogicClasses;

import LogicClasses.Utilities.AABB;
import processing.core.PApplet;
import processing.core.PImage;

public class Level {

    PApplet p;

    PImage image;

    Cell[][] cells;

    String worldType;

    public Level(PApplet p, PImage image) {

        this.p = p;

        this.image = image;

        cells = new Cell[image.width][image.height];

        calculateGrid();

    }

    public int getGridState(float x, float y) {

        int tempx = (int) PApplet.constrain(x, 0, image.width - 1);
        int tempy = (int) PApplet.constrain(y, 0, image.height - 1);

        return cells[tempx][tempy].state;

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

                int state = 0;

                if (r != 255 && g != 255 && b == 255) { // blue
                    state = 0;
                } else if (r != 255 && g == 255 && b != 255) { // green
                    state = 1;
                } else if (r == 255 && g != 255 && b != 255) { // red
                    state = 2;
                }

                cells[i][j] = new Cell(i, j, 1, 1, state);

            }
        }

    }

    public PImage getImage() {
        return image.copy();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell[] getGrid1D(){

        Cell[] grid1D = new Cell[image.width * image.height];

        for(int i = 0; i < image.width; i++){
            for(int j = 0; j < image.height; j++){

                grid1D[i + (j * image.width)] = cells[i][j];

            }
        }

        return grid1D;

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
