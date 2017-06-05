package alien_attack;

import java.awt.*;

/**
 * Created by frances on 2016-12-27.
 */
public class Egg extends GameObject {

    private int dy = 2;
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

    public void setDY(int yDir) {
        dy = yDir;
    }

    public int getDY() {
        return dy;
    }

    @Override
    void update() {

        y += dy;
        rect.y += dy;
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

    public void hatch() {
        setDY(6);
    }

    }


