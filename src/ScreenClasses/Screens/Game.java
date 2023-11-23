package ScreenClasses.Screens;

import LogicClasses.GameManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;

public class Game extends Screen{

    GameManager gameManager;

    public Game(ScreenManager screenManager) {
        
        gameManager = new GameManager(screenManager);

    }

    public void update() {

    }

    public void render() {
        
    }
    
}
