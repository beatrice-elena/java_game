package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] keys;
    public boolean up, down, left, right,enter, aRight, aLeft;


    public KeyManager(){
        keys=new boolean[256];
    }
    public void update(){
        up=keys[KeyEvent.VK_SPACE];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];
        enter=keys[KeyEvent.VK_ENTER];
        aRight=keys[KeyEvent.VK_D];
        aLeft=keys[KeyEvent.VK_A];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        System.out.println("Pressed");
    }


    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

}
