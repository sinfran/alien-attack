package game_modules;

import java.awt.*;

/**
 * Created by frances on 2016-12-27.
 */

public class Earth extends Sprite {

    public boolean move = true;
    public boolean offScreen = false;
    private int counter = 0;

    // Variables for game-over earth animation
    private int a = 3;
    private int b = 4;
    private int g = 4;

    public Earth(int x, int y, int width, int height, Image img) {

        super(x, y, width, height, img);
        //this.rect = new Rectangle(x, y + 60, width, height - 100);

    }

    @Override
    void update() {
        if (Game.state == Game.State.GAME_OVER_ANIMATION) {
            move();
        }
    }

    public void move() {
        if (move) {
            if (counter % 2 == 0) {
                if (counter % 4 == 0) {
                    x++;
                }
                y--;
                if (width >= height) {
                    width--;
                }
                if (height >= width) {
                    height--;
                }
            }
            counter++;
            if (width == 60 || height == 60) {
                move = false;
                offScreen = true;
            }
        }
    }

    @Override
    void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    public void render(Graphics g) {

        //Setting up
        Font fnt0 = new Font("times", Font.BOLD, 20);
        g.setFont(fnt0);
        Color a = new Color(255, 255, 255, this.a);
        g.setColor(a);
        g.drawString("The aliens are gone.", 60, 185);

        if (y < 430) {
            if (this.a < 220) {
                this.a += 2;
            }
        }

        if (counter > 310) {
            if (y < 375) {
                if (b < 220) {
                    b += 2;
                }
            }
            Color b = new Color(255, 255, 255, this.b);
            g.setColor(b);
            g.drawString("You have saved Earth.", 60, 220);
        }

            if (offScreen) {
                if (this.g < 220) {
                    this.g += 4;
                }
                Color c = new Color(255, 255, 255, this.g);
                g.setColor(c);
                g.drawString("Thank you for playing.", 102, 400);

        }
    }
}




