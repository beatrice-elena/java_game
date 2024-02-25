package Entities.Static;

import game.Handler;

import java.awt.*;
import Tile.Tile;
import graphics.Assets;

public class Spikes extends StaticEntities{
    public Spikes(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT );
        bounds.x=0;
        bounds.y=32;
        bounds.width=64;
        bounds.height=32;

    }
    public boolean hurtPlayer(){
        return true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spikes, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {

    }


    @Override
    public int type() {
        return 7;
    }
}
