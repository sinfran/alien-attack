package game_modules;

import java.awt.*;

/**
 * Created by frances on 2017-06-15.
 */
public class GameOverDefeated {

    private static final Font font = new Font("times", Font.BOLD, 40);
    private static Color background;

    // Variables for flickering screen animation
    private static int counter = 0;
    private static int x = 0;

    public static void render(Graphics graphics) {
        graphics.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        graphics.setColor(background);
        graphics.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        graphics.setColor(Color.white);
        graphics.setFont(font);
        graphics.drawString("GAME OVER", 70, Game.WIDTH / 2 + 84);
    }

    public static void update() {
        if (x > 5) {
            background = Color.black;
            return;
        }
        if (counter == 0 || counter == 1 || counter == 2 || counter == 3 || counter == 4 || counter == 5) {
            background = Color.blue;
        }
        if (counter == 6 || counter == 7 || counter == 8 || counter == 9 || counter == 10 || counter == 11) {
            background = Color.black;
        }
        if (counter < 12) {
            counter++;
            return;
        }
        counter = 0;
        x++;
    }

    public static void playGameOverSound() {
        MusicPlayer.evil.setVolume(-17);
        MusicPlayer.evil.run();
    }

   }


