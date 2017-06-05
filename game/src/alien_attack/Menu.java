package alien_attack;

import java.awt.*;

/**
 * Created by frances on 2016-12-28.
 */

public class Menu {
    private PlayButton playButton;
    private PlayButton helpButton;
    private Player player;

    Menu() {
        playButton = new PlayButton(Game.WIDTH / 2 - 128, 179, 255, 100, Cache.playButton);
        helpButton = new PlayButton(Game.WIDTH / 2 - 113, 290, 225, 73, Cache.helpButton);
        player = new Player((Game.WIDTH / 2) - 84, Game.HEIGHT - 220, 163, 115, Cache.player);
    }

    public void render(Graphics g) {

        Font fnt0 = new Font("times", Font.BOLD, 40);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("ALIEN ATTACK", 45, 135);
        Font fnt1 = new Font("times", Font.PLAIN, 23);
        g.setFont(fnt1);
        g.drawString("created by Frances Sin", 96, 170);

        playButton.draw(g);
        helpButton.draw(g);
        player.draw(g);
    }


}


