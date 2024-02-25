package Tile;

import java.awt.image.BufferedImage;

public class SpikesTile extends Tile{
    public SpikesTile(BufferedImage texture, int id) {
        super(texture, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
