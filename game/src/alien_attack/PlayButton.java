package alien_attack;

import java.awt.*;

/**
 * Created by frances on 2016-12-29.
 */

public class PlayButton extends GameObject {

    public PlayButton(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    @Override
    void update() {
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}
