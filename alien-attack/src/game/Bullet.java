package game;
import java.awt.*;

/**
 * Created by frances on 2016-12-25.
 */

public class Bullet extends GameObject {

    private static final int SPEED = -4;
    public boolean hit = false;

    //Constructor
    public Bullet(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    @Override
    void update() {
        y += SPEED;
        rect.y += SPEED;
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}

