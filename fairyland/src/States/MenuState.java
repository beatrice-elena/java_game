package States;
import java.awt.Component.*;
import game.Game;
import game.Handler;
import Tile.Background;
import input.KeyManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class MenuState extends State {


    private int currentChoice=0;
    private String[] options={
            "New Game",  "Exit"
    };
    private Color titleColor;
    private Font titleFont;
    private Font font;
    private Background bg;
    public MenuState(Handler handler){

        super(handler);
        try {

            bg = new Background("/textures/menu.png", 1);
            /*bg.setVector(-0.1, 0);*/

            titleColor = new Color(92, 34, 11);
            titleFont = new Font(
                    "Century Gothic",
                    Font.BOLD,
                    50);

            font = new Font("Arial", Font.PLAIN, 20);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void update() {
        getInput();
        bg.update();


    }

    @Override
    public void render(Graphics g) {
        bg.render(g);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Fairyland", 220, 150);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.WHITE);
            }
            else {
                g.setColor(Color.DARK_GRAY);
            }
            g.drawString(options[i], 280, 285 + i * 50);
        }


    }
    private void select() {
        if(currentChoice == 0) {
            GameState g=new GameState(handler);
            setState(g);
        }

        if(currentChoice == 1) {
            System.exit(0);
        }
    }
    public void getInput(){
        if(handler.getKeyManager().enter){
            select();
        }
        if(handler.getKeyManager().up) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = 0;
            }
        }
        if(handler.getKeyManager().down) {
            currentChoice++;
            if(currentChoice == 2) {
                currentChoice = 1;
            }
        }

    }


}
