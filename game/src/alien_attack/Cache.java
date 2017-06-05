package alien_attack;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by frances on 2016-12-25.
 */

public class Cache {

    private static final String IMAGE_DIR = "images/";

    //Menu
    public static Image background;
    public static Image playButton;
    public static Image helpButton;

    //Game
    public static Image earth;
    public static Image player;
    public static Image shooter;
    public static Image cont;
    public static Image continueBackground;
    public static Image bullet;
    public static Image ship;

    //Egg
    public static Image egg;
    public static Image hit;
    public static Image spawn;

    //GameOver
    public static Image moon;

    public Cache() {
        load();
    }

    public void load() {

        // Buttons
        this.background = loadImage("starry-night.png");
        this.playButton = loadImage("play_button.png");
        this.helpButton = loadImage("help_button.png");
        this.continueBackground = loadImage("continue_screen.jpg");

        this.earth = loadImage("globe.png");
        this.player = loadImage("astro.png");
        this.shooter = loadImage("shooter.png");
        this.cont = loadImage("continue.png");
        this.egg = loadImage("egg.png");
        this.hit = loadImage("egg_hit.png");
        this.spawn = loadImage("scary.gif");
        this.bullet = loadImage("fireball.png");
        this.ship = loadImage("mothership.png");
        this.moon = loadImage("moon.png");

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
