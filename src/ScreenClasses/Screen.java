package ScreenClasses;

import processing.core.PApplet;

public class Screen {
    
    protected ScreenManager screenManager;
    protected PApplet p;

    public Screen(ScreenManager screenManager) {
        this.screenManager = screenManager; 
        this.p = screenManager.getP();

    }

    public void update() {

    }

    public void render() {

    }

}
