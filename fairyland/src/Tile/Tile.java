package Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles=new Tile[256];


    public static Tile skyTile=new SkyTile(0);
    public static Tile bg1Tile=new Bg1Tile(1);
    public static Tile bg2Tile=new Bg2Tile(2);
    public static Tile bg3Tile=new Bg3Tile(3);
    public static Tile grassTile=new GrassTile(4);
    public static Tile dirtTile=new DirtTile(5);
    public static Tile waterTile=new WaterTile(6);
    public static Tile wavesTile=new WavesTile(7);
    public static Tile stepTile=new WavesTile(8);




    public static final int TILE_WIDTH=64;
    public static final int TILE_HEIGHT=64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture=texture;
        this.id=id;

        tiles[id]=this;
    }
    public int getId(){
        return id;
    }
    public void update(){

    }
    public boolean isSolid(){
        return false;
    }
    public boolean die(){
        return false;
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }
}
