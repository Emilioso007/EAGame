/*
 * A helper class that keeps track of the mouse position and buttons.
 */

package LogicClasses.Utilities;

import processing.core.PApplet;

public class MH {

    private static PApplet p;

    public static boolean leftPressed, rightPressed;
    public static int mouseX, mouseY;

    private MH() {
    }

    public static void initialize(PApplet p) {
        MH.p = p;
    }

    public static void update() {
        leftPressed = p.mousePressed && p.mouseButton == PApplet.LEFT;
        rightPressed = p.mousePressed && p.mouseButton == PApplet.RIGHT;
        mouseX = p.mouseX;
        mouseY = p.mouseY;
    }

}
