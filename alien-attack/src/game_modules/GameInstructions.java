package game_modules;

import java.awt.*;

/**
 * Created by frances on 2016-12-31.
 */

public class GameInstructions {

    private static final int spacing = 22;
    private static final int yStart = 100;
    private static final int xPos = 10;
    private PlayButton backButton = new PlayButton(27, 27, 30, 30, Cache.backButton);
    private PlayButton keys = new PlayButton(148, 120, 90, 60, Cache.keys);
    private PlayButton space = new PlayButton(120, 228, 150, 47, Cache.spacebar);
    private PlayButton clock = new PlayButton(138, 321, 105, 105, Cache.clock);


    public void render(Graphics g) {

        // Setting up
        g.setColor(Color.white);
        Font fnt0 = new Font("times", Font.BOLD, 40);
        Font fnt1 = new Font("times", Font.PLAIN, 16);
        Font fnt2 = new Font("times", Font.PLAIN, 30);

        // Title
        g.setFont(fnt0);
        g.drawString("Instructions", 94, 55);

        backButton.draw(g);
        keys.draw(g);
        space.draw(g);
        clock.draw(g);

        // Instructions
        g.setFont(fnt1);
        g.drawString("Move around with the LEFT and RIGHT arrow keys", xPos, yStart);
        g.drawString("Press the SPACEBAR to shoot bullets at the UFOs above", xPos, yStart + (spacing * 5));
        g.drawString("If you hit an alien egg, it will be activated and will hatch", xPos, yStart + (9 * spacing) + 5);
        g.drawString("after a short delay", xPos, yStart + (10 * spacing));
        g.drawString("It is YOUR mission to destroy the enemy UFOs and prevent", xPos, yStart + (16 * spacing));
        g.drawString("any of the eggs from reaching Earth.", xPos, yStart + (17 * spacing));
        g.setFont(fnt2);
        g.drawString("Good luck...", 12 * xPos, yStart + (19 * spacing) +10 );
    }
}
