package game_modules;

import java.awt.*;

/**
 * Created by frances on 2016-12-27.
 */
public class MotherShip extends Sprite {

    public MotherShip(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    @Override
    void update() {
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}
