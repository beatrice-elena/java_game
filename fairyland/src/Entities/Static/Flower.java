package Entities.Static;

import Tile.Tile;
import game.Handler;
import graphics.Assets;
import Entities.EntityManager;

import java.awt.*;

public class Flower extends StaticEntities{
    public Flower(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);


        bounds.x=16;
        bounds.y=16;
        bounds.width=16;
        bounds.height=16;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.flower, (int) (x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()) , width, height,null);
    }

    @Override
    public void die() {

    }

    @Override
    public int type() {
        return 1;
    }

    public boolean getScore(){
        return true;
    }
}
