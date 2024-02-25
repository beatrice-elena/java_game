package States;

import Entities.Player;
import Entities.Static.Tree;
import Worlds.World;
import game.Game;
import game.Handler;
import graphics.Assets;

import java.awt.*;
import Tile.Tile;

public class GameState extends State{

    private World world;





public GameState(Handler handler){
    super(handler);
    world=new World(handler,"res/worlds/world1.txt");
    handler.setWorld(world);




}
    @Override
    public void update() {
    world.update();


    }

    @Override
    public void render(Graphics g) {
    world.render(g);




    }
}
