package States;

import Tile.Background;
import game.Handler;

import java.awt.*;

public class GameOverState extends State {
    private Color titleColor;
    private Font titleFont;
    private Font font;
    private Background bg;

    public GameOverState(Handler handler){
        super(handler);
        try {

            bg = new Background("/textures/menu.png", 1);
            /*bg.setVector(-0.1, 0);*/

            titleColor = new Color(78, 35, 17);
            titleFont = new Font(
                    "Century Gothic",
                    Font.BOLD,
                    28);



        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
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
        g.drawString("GAME OVER-PRESS ENTER", 150, 150);

    }
    public void getInput(){
        if(handler.getKeyManager().enter){
            MenuState m=new MenuState(handler);
            setState(m);}
    }
}
