package Entities;

import Entities.Static.Flower;
import States.MenuState;
import States.State;
import game.Handler;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EntityManager {

    private Color titleColor;
    private Font titleFont;
    private BufferedImage img;
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    State menuState;

    public int score=0;

    public EntityManager(Handler handler, Player player){
        this.handler=handler;
        this.player=player;
        titleColor = new Color(7, 114, 123);
        titleFont = new Font(
                "Arial",
                Font.BOLD,
                20);

        entities=new ArrayList<Entity>();
        addEntity(player);


    }

    public void update(){
    for(int i=0;i<entities.size();i++){
        Entity e=entities.get(i);
        e.update();
        if(!e.isActive()){
            entities.remove(e);
        if(e.type()==1)
            score++;
        else if(e.type()==5)
            score=score+5;
        System.out.println(score);}


    }
    if(score==1)
    {
        menuState=new MenuState(handler);
        State.setState(menuState);
    }


    }
    public void render(Graphics g){
        for(Entity e:entities){
            e.render(g);
        }
        player.render(g);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Score:" +score, 32, 32);
        g.drawImage(Assets.flower,0,0,32,32,null);



    }
    public void addEntity(Entity e){
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
