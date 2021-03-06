package game_modules;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by frances on 2016-12-25.
 */

public class Cache {

    private static final String IMAGE_DIR = "images/";


    public static Image keys;
    public static Image spacebar;
    public static Image clock;

    //GameMenu
    //public static Image background;
    public static Image playButton;
    public static Image helpButton;

    public static Image backButton;

    //Game
    public static Image earth;
    public static Image player_right;
    public static Image player_left;
    public static Image shooter;
    public static Image cont;
    public static Image background;
    public static Image bullet;
    public static Image ship;

    //Egg
    public static Image egg;
    public static Image hit;
    public static Image spawn;

    //GameOver

    public Cache() {
        load();
    }

    public void load() {

        // Buttons
        this.playButton = loadImage("play_button.png");
        this.backButton = loadImage("back.png");
        this.helpButton = loadImage("help_button.png");


        // Images for instruction page
        this.keys = loadImage("keys.png");
        this.spacebar = loadImage("spacebar.png");
        this.clock = loadImage("clock.png");

        this.background = loadImage("continue_screen.jpg");

        this.earth = loadImage("globe.png");
        this.player_right = loadImage("astro.png");
        this.player_left = loadImage("astro_L.png");
        this.shooter = loadImage("shooter.png");
        this.cont = loadImage("continue.png");
        this.egg = loadImage("egg.png");
        this.hit = loadImage("egg_hit.png");
        this.spawn = loadImage("scary.gif");
        this.bullet = loadImage("fireball.png");
        this.ship = loadImage("mothership.png");
    }

    private Image loadImage(String img) {
        try {
            return ImageIO.read(new File(IMAGE_DIR + img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
