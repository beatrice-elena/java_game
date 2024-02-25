package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=128;
    private static final int height=128;
    public static BufferedImage[] player_walk_right;
    public static BufferedImage[] player_walk_left;
    public static BufferedImage[] player_idle;
    public static BufferedImage[] player_fly;
    public static BufferedImage[] player_jump;
    public static BufferedImage[] player_fall;
    public static BufferedImage[] player_die;
    public static BufferedImage grass;
    public static BufferedImage water;
    public static BufferedImage waves;
    public static BufferedImage sky;
    public static BufferedImage dirt;
    public static BufferedImage step;
    public static BufferedImage bg1;
    public static BufferedImage bg2;
    public static BufferedImage bg3;
    public static BufferedImage tree;
    public static BufferedImage toptree;
    public static BufferedImage bottomtree;
    public static BufferedImage flower;
    public static BufferedImage[] bird_fly;
    public static BufferedImage[] bird_got_hit;
    public static BufferedImage spikes;


    public static void init(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/t.png"));

        bird_fly=new BufferedImage[4];
        bird_fly[0]=sheet.crop(width*8,height*2,width,height);
        bird_fly[1]=sheet.crop(width*9,height*2,width,height);
        bird_fly[2]=sheet.crop(width*10,height*2,width,height);
        bird_fly[3]=sheet.crop(width*11,height*2,width,height);

        bird_got_hit=new BufferedImage[2];
        bird_got_hit[0]=sheet.crop(width*14,height*2,width,height);
        bird_got_hit[1]=sheet.crop(width*16,height*2,width,height);


        player_walk_right=new BufferedImage[6];
        player_walk_right[0]= sheet.crop(width*3,0,width,height);
        player_walk_right[1]= sheet.crop(width*4,0,width,height);
        player_walk_right[2]= sheet.crop(width*5,0,width,height);
        player_walk_right[3]= sheet.crop(width*6,0,width,height);
        player_walk_right[4]= sheet.crop(width*7,0,width,height);
        player_walk_right[5]= sheet.crop(width*8,0,width,height);

        player_walk_left=new BufferedImage[6];
        player_walk_left[0]= sheet.crop(width*10,6*height,width,height);
        player_walk_left[1]= sheet.crop(width*11,6*height,width,height);
        player_walk_left[2]= sheet.crop(width*12,6*height,width,height);
        player_walk_left[3]= sheet.crop(width*13,6*height,width,height);
        player_walk_left[4]= sheet.crop(width*14,6*height,width,height);
        player_walk_left[5]= sheet.crop(width*15,6*height,width,height);

        player_idle=new BufferedImage[1];
        player_idle[0]= sheet.crop(width,0,width,height);

        player_fly=new BufferedImage[4];
        player_fly[0]=sheet.crop(width*10,0,width,height);
        player_fly[1]=sheet.crop(width*11,0,width,height);
        player_fly[2]=sheet.crop(width*12,0,width,height);
        player_fly[3]=sheet.crop(width*13,0,width,height);

        player_jump=new BufferedImage[5];
        player_jump[0]=sheet.crop(width,height,width,height);
        player_jump[1]=sheet.crop(2*width,height,width,height);
        player_jump[2]=sheet.crop(3*width,height,width,height);
        player_jump[3]=sheet.crop(4*width,height,width,height);
        player_jump[4]=sheet.crop(5*width,height,width,height);

        player_fall=new BufferedImage[2];
        player_fall[0]=sheet.crop(13*width,height, width,height);
        player_fall[1]=sheet.crop(14*width,height, width,height);

        player_die=new BufferedImage[3];
        player_die[0]=sheet.crop(0,2*height,width,height);
        player_die[1]=sheet.crop(width,2*height,width,height);
        player_die[2]=sheet.crop(2*width,2*height,width,height);


        toptree=sheet.crop(11*width,4*height,width,height);
        bottomtree=sheet.crop(11*width,5*height,width,height);
        flower= sheet.crop(6*width,4*height,width,height);
        tree= sheet.crop(width*5,height*4,width,height);
        grass=sheet.crop(width,3*height,width,height);
        water=sheet.crop(width*2,height*4, width,height);
        waves=sheet.crop(width*1,height*4, width,height);
        dirt=sheet.crop(width*12,height*3, width,height);
        step=sheet.crop(width*7,height*3, width,height);
        sky=sheet.crop(0,5*height,width,height);
        bg1=sheet.crop(0,7*height,width,height);
        bg2=sheet.crop(0,8*height,width,height);
        bg3=sheet.crop(0,9*height,width,height);
        spikes=sheet.crop(width*13,height*4,width,height);
    }

}
