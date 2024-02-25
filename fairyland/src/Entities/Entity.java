package Entities;

import game.Game;
import game.Handler;

import java.awt.*;

public abstract class Entity {


    protected Handler handler;
    protected float x;
    protected float y;
    public int score;

    protected int width;
    protected int height;

    protected Rectangle bounds;

    protected boolean active = true;
    protected int health;
    public static final int DEFAULT_HEALTH = 2;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;
        score=0;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void update();

    public abstract void render(Graphics g);


    public abstract void die();

    public void hurt(int amt) {
        health -=amt;
        if (health <= 0) {
            active = false;
            die();
        }
    }

    public boolean checkEntityCollision(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;

        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    public abstract int type(); //pt enemy-0, flower-1,


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
