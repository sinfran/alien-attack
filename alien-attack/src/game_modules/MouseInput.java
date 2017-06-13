package game_modules;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by frances on 2016-12-28.
 */

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if (Game.state == Game.State.MENU) {
            // Play button
            if (mx >= Game.WIDTH / 2 - 103 && mx <= Game.WIDTH / 2 - 103 + 210) {
                if (my >= 206 && my <= 206 + 50) {
                    MusicPlayer.transition.run();
                    Game.state = Game.State.GAME_IN_PROGRESS;
                    MusicPlayer.songMenu.stopSound();
                    MusicPlayer.songGame.setVolume(-20);
                    MusicPlayer.songGame.run();
                }
            }
            // Help button
            if (mx >= Game.WIDTH / 2 - 103 && mx <= Game.WIDTH / 2 - 103 + 210) {
                if (my >= 317 && my <= 317 + 50) {
                    MusicPlayer.transition.run();
                    Game.state = Game.State.HELP;
                }
            }
        }

        // Back button
        if (Game.state == Game.State.HELP) {
            if (mx >= 24 && mx <= 54)
                if (my >= 27 && my <= 52) {
                MusicPlayer.transition.run();
                Game.state = Game.State.MENU;
                }
        }

        // Continue button
        if (Game.state == Game.State.GAME_OVER_WON) {
                if (mx >= Game.WIDTH / 2 - 104 && mx <= Game.WIDTH / 2 - 103 + 196) {
                    if (my >= 259 && my <= 304) {
                        MusicPlayer.transition.run();
                        MusicPlayer.songGame.stopSound();
                        MusicPlayer.transition.setVolume(-27);
                        MusicPlayer.transition.run();
                        MusicPlayer.songGameOver.run();
                        Game.state = Game.State.GAME_OVER_ANIMATION;
                    }
                }
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
