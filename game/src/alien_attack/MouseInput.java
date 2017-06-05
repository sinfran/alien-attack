package alien_attack;

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

        if (Game.State == Game.STATE.MENU) {
            if (mx >= Game.WIDTH / 2 - 103 && mx <= Game.WIDTH / 2 - 103 + 210) {
                if (my >= 206 && my <= 206 + 50) {
                    MusicPlayer.start.setVolume(-27);
                    MusicPlayer.start.run();
                    Game.State = Game.STATE.GAME;
                    MusicPlayer.songMenu.stopSound();
                    MusicPlayer.songGame.setVolume(-28);
                    MusicPlayer.songGame.run();
                }
            }
            if (mx >= Game.WIDTH / 2 - 103 && mx <= Game.WIDTH / 2 - 103 + 210) {
                if (my >= 317 && my <= 317 + 50) {
                    Game.State = Game.STATE.HELP;
                }
            }
        }
        if (Game.State == Game.STATE.WON && Game.gameOver) {
            if (Game.gameOver) {
                if (mx >= Game.WIDTH / 2 - 104 && mx <= Game.WIDTH / 2 - 103 + 196) {
                    if (my >= 259 && my <= 304) {
                        MusicPlayer.songGame.stopSound();
                        MusicPlayer.start.setVolume(-27);
                        MusicPlayer.start.run();
                        MusicPlayer.songGameOver.run();
                        Game.State = Game.STATE.GAMEOVER;
                    }
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
