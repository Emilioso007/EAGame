package ScreenClasses.Screens;

import LogicClasses.GameManager;
import LogicClasses.LevelManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;

public class Game extends Screen{

    GameManager gameManager;

    PApplet p;

    public Game(ScreenManager screenManager) {
        
        gameManager = new GameManager(screenManager);

        this.p = screenManager.getP();

    }

    public void update() {
        gameManager.update();
    }

    public void render() {
        
        p.fill(255);

        p.ellipseMode(PApplet.RADIUS);
        p.ellipse(gameManager.getBall().getX(), gameManager.getBall().getY(), gameManager.getBall().getRadius(), gameManager.getBall().getRadius());


    }
    
}
