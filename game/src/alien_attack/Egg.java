package alien_attack;

import java.awt.*;
import java.util.Random;

/**
 * Created by frances on 2016-12-27.
 */
public class Egg extends GameObject {

    private static final int JIGGLE_X = 1;
    private float dy = 1.7f;
    public boolean hit = false;
    public boolean spawn = false;
    public boolean alreadyHit = false;

    public Egg(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    public Image getImage() {
        return this.img;
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public void setDY(float yDir) {
        dy = yDir;
    }

    public float getDY() { return dy; }

    public void hatch() {
        setDY(3.1f);
    }

    @Override
    void update() {
        y += dy;
        rect.y += dy;

        // alien babies jiggle as they fall down the screen
        if (spawn == true) {
            x = x + new Random().nextInt(2 * JIGGLE_X + 1) - JIGGLE_X;
        }

        if (hit == true && alreadyHit == false) {
            setImage(Cache.hit);
            hit = false;
            alreadyHit = true;
        }

        if (spawn == true) {
            setImage(Cache.spawn);
        }
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

}
