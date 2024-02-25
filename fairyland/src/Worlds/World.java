package Worlds;

import Entities.Enemy;
import Entities.EntityManager;
import Entities.Player;
import Entities.Static.*;
import Tile.Tile;
import Utils.Utils;
import game.Game;
import game.Handler;

import java.awt.*;

public class World {


    private Handler handler;
    private int width;
    private int height;

    private EntityManager entityManager;

    private int spawnx;
    private int spawny;

    private int[][] tiles;

    public World(Handler handler, String path){

        this.handler=handler;
        entityManager=new EntityManager(handler,new Player(handler,10,100));
        for(int i=0;i<384;i=i+128) {
        entityManager.addEntity(new BottomTree(handler,i,200));}
        for(int i=0;i<384;i=i+128){
        entityManager.addEntity(new TopTree(handler,i,136));
        }

        entityManager.addEntity(new Flower(handler, 100, 200));
        entityManager.addEntity(new Flower(handler, 300, 200));
        entityManager.addEntity(new Tree(handler,50,200));
        entityManager.addEntity(new Tree(handler,200,200));
        entityManager.addEntity(new Step(handler,704,200));
        entityManager.addEntity(new Step(handler,832, 136));
        entityManager.addEntity(new Step(handler,1150,136));
        entityManager.addEntity(new Spikes(handler,1400,64));
        for(int i=1600;i<1800;i=i+64){
            entityManager.addEntity(new Flower(handler, i, 70));
        }
        for(int i=2100;i<2300;i=i+64){
            entityManager.addEntity(new Flower(handler, i, 200));
        }
        for(int i=2800;i<3000;i=i+64){
            entityManager.addEntity(new Flower(handler, i, 264));
        }
        for(int i=960;i<=1053;i=i+64){
            entityManager.addEntity(new Step(handler,i, 136));
        }
        for(int i=2048;i<=2368;i=i+64){
            entityManager.addEntity(new Step(handler,i, 256));

        }
        entityManager.addEntity(new Spikes(handler,2200,256));

        for(int i=3328;i<=3456;i=i+64){
            entityManager.addEntity(new Step(handler,i, 256));
        }
        entityManager.addEntity(new Enemy(handler,400,200));

        entityManager.addEntity(new Step(handler,3584, 256));
        entityManager.addEntity(new Step(handler,3712
                , 256));
        entityManager.addEntity(new Flower(handler,3712
                , 200));


        for(int i=640;i<1280;i=i+64){
            entityManager.addEntity(new Wave(handler,i,258));
        }
        for(int i=1920;i<2560;i=i+64){
            entityManager.addEntity(new Wave(handler,i,322));
        }
        for(int i=3200;i<3840;i=i+64){
            entityManager.addEntity(new Wave(handler,i,322));
        }
        entityManager.addEntity(new Spikes(handler,200,200));


        loadworld(path);

        entityManager.getPlayer().setX(spawnx);
        entityManager.getPlayer().setY(spawny);


    }

    public void update(){
 entityManager.update();
    }
    public void render(Graphics g){
        int xStart=(int)Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int yStart=(int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int xEnd=(int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILE_WIDTH+1);
        int yEnd=(int) Math.min(height,(handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILE_HEIGHT+1);


        for(int y=yStart;y<yEnd;y++){
                for(int x=xStart;x<xEnd;x++) {
                    getTile(x,y).render(g,(int)(x*Tile.TILE_WIDTH-handler.getGameCamera().getxOffset())
                            ,(int)(y*Tile.TILE_HEIGHT-handler.getGameCamera().getyOffset()));
                }}
        entityManager.render(g);


    }
    public Tile getTile(int x, int y){
        if(x<0|| y<0||x>=width||y>=height)
            return Tile.grassTile;

        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null)
            return Tile.dirtTile;
        return t;
    }

    private void loadworld(String path){
        String file= Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        height=Utils.parseInt(tokens[1]);
        spawnx=Utils.parseInt(tokens[2]);
        spawny=Utils.parseInt(tokens[3]);

        tiles=new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x][y]=Utils.parseInt(tokens[(x+y*width) + 4]);
            }
        }

    }
    public int getWidth(){
        return width;

    }
    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
