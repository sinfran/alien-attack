package game;

import java.awt.*;

/**
 * Created by frances on 2016-12-29.
 */
public class HealthBar {

    public void paint(Graphics g, UFOShooter s) {

        int health = s.health * 5;

        g.setColor(Color.gray);
        g.fillRect(s.x + 18, s.y + 48, 50, 8);

        g.setColor(Color.green);
        g.fillRect(s.x + 18, s.y + 48, health, 8);

        g.setColor(Color.white);
        g.drawRect(s.x + 18, s.y + 48, 50, 8);
    }
}

