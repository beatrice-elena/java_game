package graphics;

import Entities.Entity;
import Tile.Tile;
import game.Game;
import game.Handler;

public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;


    public void centerOnPlayer(Entity e){
        xOffset=e.getX()- handler.getWidth()/2 + e.getWidth()/2;
        yOffset=e.getY()- handler.getHeight()/2 + e.getHeight()/2;
        checkBlank();
    }


    public GameCamera(Handler handler, float xOffset, float yOffset ){

        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.handler=handler;
    }
    public void move(float xAmt, float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
        checkBlank();
    }

    public void checkBlank(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }

        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }
    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
