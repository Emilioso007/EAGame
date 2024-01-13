package ScreenClasses.Screens;

import java.util.ArrayList;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button;
import processing.core.PApplet;

public class StartMenu extends Screen{

    private PApplet p;
    private ArrayList<Button> buttons;

    public StartMenu() {
        super();
        p = ScreenManager.p;

        buttons = new ArrayList<Button>();
        buttons.add(new Button(p.width / 2 - 100, p.height / 2 - 50, 200, 100, "Start", "startButton"));
        buttons.add(new Button(p.width / 2 - 100, p.height / 2 + 100, 200, 100, "Exit", "exitButton"));
    }

    public void update() {
        
        for(Button button : buttons){
            button.update();
        }

        for(int i = 0; i < buttons.size(); i++){
            if(buttons.get(i).pressed){
                switch(buttons.get(i).key){
                    case "startButton":
                        ScreenManager.changeScreen(new Game());
                        break;
                    case "exitButton":
                        p.exit();
                        break;
                }
            }
        }

    }

    public void render() {

        for(Button button : buttons){
            button.render(p);
        }

    }

}
