package Tile;

import game.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private Handler handler;
    private BufferedImage image;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private double moveScale;

    public Background(String s, double ms) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
            moveScale=ms;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setPosition(double x, double y){
        this.x=(x*moveScale)% handler.getWidth();
        this.y=(y*moveScale)%handler.getHeight();
    }
    public void setVector(double dx, double dy){
        this.dx=dx;
        this.dy=dy;
    }
    public void update(){
        x+=dx;
        y+=dy;
    }
    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y,640,500, null);

    }
}


