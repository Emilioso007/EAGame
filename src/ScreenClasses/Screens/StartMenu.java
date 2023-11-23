package ScreenClasses.Screens;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;

public class StartMenu extends Screen{
    
    ScreenManager screenManager;
    PApplet p;

    public StartMenu(ScreenManager screenManager) {
        this.screenManager = screenManager; 
        this.p = screenManager.getP();
    }

    public void update() {
        if(p.mousePressed){
            screenManager.changeScreen(new Game(screenManager));

        }
    }

    public void render() {
        p.fill(255);
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Click anywhere to start", p.width / 2, p.height / 2);
    }

}
