package ScreenClasses.Screens;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PImage;

public class EndScreen extends Screen{

    private PApplet p;
    private PImage background;

    public EndScreen() {
        super();
        p = ScreenManager.p;
        background = p.loadImage("Images/Backgrounds/EndScreen.png");
    }

    public void update() {

    }

    public void render() {
        p.background(0);

        p.image(background, 0, 0);

    }

}
