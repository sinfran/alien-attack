package game;

import java.awt.*;

/**
 * Created by frances on 2016-12-25.
 */

public class Player extends GameObject {

    private static final int SPEED = 8;
    public boolean left;
    public boolean right;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, Cache.player_right);
        this.rect = new Rectangle(x + 13, y + 23, width - 30, height - 70);
    }

    @Override
    public void update() {
        if (left) {
            x -= SPEED;
            rect.x -= SPEED;
            img = Cache.player_left;
        }

        if (right) {
            x += SPEED;
            rect.x += SPEED;
            img = Cache.player_right;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

}
