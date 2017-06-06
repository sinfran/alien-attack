package game_modules;

import java.awt.*;
import java.util.Random;

/**
 * Created by frances on 2016-12-25.
 */

public class UFOShooter extends GameObject {

    // Initialize position of each shooter at the transition of the game_modules
    Random rand = new Random();
    public int pos = rand.nextInt(150) + 79;

    public int health = 1;
    public boolean isAlive = true;

    private boolean moveLeft = true;
    private int counter = 0;

    // Construct shooter at random posn on game_modules screen
    public UFOShooter(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
        rect = new Rectangle(x + 1, y, width - 24, height - 15);
    }

    @Override
    void update() {
        moveAround();
        fire();
    }

    private void moveAround() {
        if (moveLeft) {
            x--;
            rect.x--;
            if (x == -20) {
                moveLeft = false;
            }
        }
        if (!moveLeft) {
            x++;
            rect.x++;
            if (x == Game.WIDTH - 20) {
                moveLeft = true;
            }
        }
    }

    private void fire() {
        if (this.isAlive && counter % pos == 0) {
            Egg egg = new Egg(this.x + 30, this.y + 25 + 1, 40, 45, Cache.egg);
            Game.eggs.add(egg);
        }
        counter++;
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}
