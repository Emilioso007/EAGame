//test1

import LogicClasses.Utilities.MH;
import ScreenClasses.ScreenManager;
import ScreenClasses.Screens.StartMenu;
import processing.core.*;

public class App extends PApplet {

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(1280, 720, P2D);
        smooth(8);
    }

    public void setup() {
        MH.initialize(this);
        ScreenManager.initialize(this);
        ScreenManager.changeScreen(new StartMenu());
    }

    public void draw() {
        MH.update();

        ScreenManager.run();

        showFPS();
    }

    private void showFPS() {
        fill(255);
        textSize(16);
        textAlign(RIGHT, TOP);
        text("FPS: " + (int) frameRate, width, 0);
    }

}