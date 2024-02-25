package Tile;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class DirtTile extends Tile{

    public DirtTile( int id) {
        super(Assets.dirt, id);

    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
