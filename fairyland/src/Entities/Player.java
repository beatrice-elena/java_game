package Entities;

import Entities.Static.Spikes;
import States.GameOverState;
import States.State;
import Tile.Tile;
import game.Game;
import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {



    private Animation walk_right, walk_left, idle, fly,jump, fall,die;
    int fallingSpeed = 5;
    int gravity = 2;
    int jumpPower = -100;

    State go;
    private boolean isJumping = false;


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        bounds.x = 16;
        bounds.y =16;
        bounds.width = 32;
        bounds.height = 32;


        walk_right = new Animation(300, Assets.player_walk_right);
        walk_left = new Animation(300, Assets.player_walk_left);
        idle = new Animation(0, Assets.player_idle);
        fly = new Animation(200, Assets.player_fly);
        jump=new Animation(200,Assets.player_jump);
        fall=new Animation(200,Assets.player_fly);
        die=new Animation(200,Assets.player_die);

    }

    @Override
    public void update() {

        walk_right.update();
        walk_left.update();
        idle.update();
        fly.update();
        jump.update();
        fall.update();
        die.update();

        getInput();
        move();
        handler.getGameCamera().centerOnPlayer(this);
        collectFlowers();
        die();

    }

    public void die(){
        if (yMove > 0) {
            int ty = (int) (y + yMove + bounds.y + bounds.getHeight()) / Tile.TILE_HEIGHT;

            if (playerDies((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    playerDies((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty))
            {
                 health=0;

            }
        }for(Entity e:handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            if(e.isActive() && e.type()==7 && e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(handler.getWorld().getEntityManager().getPlayer().getxMove(),handler.getWorld().getEntityManager().getPlayer().getyMove())))

                health--;
        }

        if(health==0)
        {
            go=new GameOverState(handler);
            State.setState(go);
        }


    }
    private void collectFlowers(){
        Rectangle cb=getCollisionBounds(0,0);
        Rectangle ar=new Rectangle();
        int arSize=20;
        ar.width=arSize;
        ar.height=arSize;

        if(handler.getKeyManager().aRight)
        {
            ar.x=cb.x+cb.width;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else if(handler.getKeyManager().aLeft){
            ar.x=cb.x-arSize;
            ar.y=cb.y+cb.height/2-arSize/2;
        } else{
            return;
        }
        for(Entity e:handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar) && (e.type()==1 || e.type()==5) ){
                e.hurt(1);
                return;
            }
        }

    }


    private void getInput() {
        xMove = 0;
        yMove = gravity;

        if (handler.getKeyManager().up )
        {
            //xMove+=64;
            jump();




        }

        if (handler.getKeyManager().left)
            xMove = -speed;
        if (handler.getKeyManager().right)
            xMove = speed;


    }

    public void jump() {
        isJumping = true;
        fallingSpeed = jumpPower;
        fall();
    }

    public void fall() {
        yMove += fallingSpeed;
        fallingSpeed = fallingSpeed + gravity;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    public int type() {
        return 6;
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return walk_left.getCurrentFrame();
        } else if (xMove > 0) {
            return walk_right.getCurrentFrame();
        } else if (yMove < 0) {
            return jump.getCurrentFrame();
        } else if (yMove > 0) {
            return idle.getCurrentFrame();
        }
        else return idle.getCurrentFrame();

    }
}