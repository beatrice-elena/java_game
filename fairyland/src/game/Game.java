package game;

import States.GameOverState;
import States.GameState;
import States.MenuState;
import States.State;
import graphics.Assets;
import graphics.GameCamera;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import input.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;

    private int width;
    private int height;
    public String title;

    private Thread thread;
    private boolean running=false;

    private BufferStrategy bs;
    private Graphics g;

    //states
    private State gameState;
    private State menuState;
    private State gameoverState;

    //input

    private KeyManager keyManager;

    private GameCamera gameCamera;

    private Handler handler;




    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager=new KeyManager();

    }
    public void run(){
        init();

        int fps=60;
        double time=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer=0;
        int ticks=0;

        while(running){
            now=System.nanoTime();
            delta+=(now-lastTime)/time;
            timer+=now-lastTime;
            lastTime=now;

            if(delta>=1) {
                update();
                render();
                ticks++;
                delta--;
            }
            if(timer>=1000000000) {
                ticks=0;
                timer=0;
            }

        }
        stop();


    }
    private void update(){
        keyManager.update();

        if(State.getState()!=null)
            State.getState().update();

    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        g.clearRect(0,0,width,height);

        if(State.getState()!=null)
            State.getState().render(g);

        bs.show();
        g.dispose();
    }
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();


        handler=new Handler(this);
        gameCamera=new GameCamera(handler,0,0);

        gameState=new GameState(handler);
        menuState=new MenuState(handler);
        gameoverState=new GameOverState(handler);
        State.setState(menuState);
    }
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public KeyManager getKeyManager(){
        return  keyManager;
    }
    public synchronized void start(){
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
