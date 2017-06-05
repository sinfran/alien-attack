package game_modules;

import java.awt.*;

/**
 * Created by frances on 2016-12-31.
 */

public class Instructions {

    private static final int spacing = 20;
    private static final int yStart = 86;
    private static final int xPos = 9;

    public void render(Graphics g) {

        //Setting up
        g.setColor(Color.white);
        Font fnt0 = new Font("times", Font.BOLD, 40);
        Font fnt1 = new Font("times", Font.PLAIN, 15);

        //Title
        g.setFont(fnt0);
        g.drawString("Instructions", 86, 48);

        //Instructions
        g.setFont(fnt1);
        g.drawString("Use the LEFT and RIGHT arrow keys to move around.", xPos, yStart);
        g.drawString("Press the space bar to shoot your bullets at the UFOs above.", xPos, yStart + spacing);
        g.drawString("If you hit an alien egg, it will be activated and will hatch after", xPos, yStart + 2 * spacing);
        g.drawString("a short delay.", xPos, yStart + 3 * spacing);
        g.drawString("It is your mission to destroy the enemy UFOs and to prevent", xPos, yStart + 5 * spacing);
        g.drawString("any of the eggs from reaching Earth.", xPos, yStart + 6 * spacing);
        g.drawString("Good luck...", 17 * xPos, yStart + 8 * spacing);
    }
}
