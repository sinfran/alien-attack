package alien_attack;

import java.awt.*;

/**
 * Created by frances on 2016-12-28.
 */
public class Menu {

    public void render(Graphics g) {

        Font fnt0 = new Font("times", Font.BOLD, 40);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("ALIEN ATTACK", 25, 120);
        Font fnt1 = new Font("times", Font.PLAIN, 23);
        g.setFont(fnt1);
        g.drawString("created by Frances Sin", 96, 160);

    }
}


