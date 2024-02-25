package Entities;

import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Entity{

    private Animation got_hit, fly;
    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y,  Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        got_hit=new Animation(200, Assets.bird_got_hit);
        fly=new Animation(200,Assets.bird_fly);
        health=10;


    }

    @Override
    public void update() {
        got_hit.update();
        fly.update();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    @Override
    public void die() {

    }

    @Override
    public int type() {
        return 5;
    }
    public BufferedImage getCurrentAnimationFrame() {
       if(health<5)
           return got_hit.getCurrentFrame();
        return fly.getCurrentFrame();
    }


    }



