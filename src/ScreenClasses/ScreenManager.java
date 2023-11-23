package ScreenClasses;

import ScreenClasses.Screens.StartMenu;
import processing.core.PApplet;

public class ScreenManager {

    private PApplet p;
    private Screen currentScreen;

    public ScreenManager(PApplet p) {
        this.p = p;

        this.currentScreen = new StartMenu(this);
    }

    public void run() {
        update();
        render();
    }

    public void update() {
        currentScreen.update();
    }

    public void render() {
        currentScreen.render();

        p.fill(255);
        p.textSize(16);
        p.textAlign(PApplet.RIGHT, PApplet.TOP);
        p.text("FPS: " + (int) p.frameRate, p.width, 0);
    }

    public PApplet getP() {
        return p;
    }

    public void changeScreen(Screen screen) {
        currentScreen = screen;
    }

}
