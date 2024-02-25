package Tile;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class WaterTile extends Tile{
    public WaterTile( int id) {
        super(Assets.water, id);
    }

    @Override
    public boolean die() {
        return true;
    }
}
