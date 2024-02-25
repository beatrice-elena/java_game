package Entities.Static;

import Tile.Tile;
import game.Handler;
import graphics.Assets;

import java.awt.*;

public class Step extends StaticEntities {
    public Step(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);


        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 64;
        bounds.height = 32;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.step, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    @Override
    public void die() {

    }

    @Override
    public int type() {
        return 2;
    }
}