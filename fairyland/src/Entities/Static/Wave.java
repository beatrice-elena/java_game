package Entities.Static;

import Tile.Tile;
import game.Handler;
import graphics.Assets;

import java.awt.*;

public class Wave extends StaticEntities {
    public Wave(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);


        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 0;
        bounds.height = 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.waves, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    @Override
    public void die() {

    }

    @Override
    public int type() {
        return 4;
    }
}