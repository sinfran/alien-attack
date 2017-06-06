package game_modules;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static game_modules.Game.state;

/**
 * Created by frances on 2017-06-05.
 */

public class KeyInput implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (state == Game.State.GAME_IN_PROGRESS) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Game.player.right = true;

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Game.player.left = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (state == Game.State.GAME_IN_PROGRESS) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Game.player.right = false;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Game.player.left = false;
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                Bullet bullet = new Bullet(Game.player.x + 60, Game.player.y, 10, 10, Cache.bullet);
                Game.playerBullets.add(bullet);
                MusicPlayer.zap.setVolume(-40);
                MusicPlayer.zap.run();
            }
        }
    }
}
