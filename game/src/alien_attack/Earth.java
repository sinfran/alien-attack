package alien_attack;

import java.awt.*;

/**
 * Created by frances on 2016-12-27.
 */

public class Earth extends GameObject {

    public boolean move = true;
    public boolean offScreen = false;
    private int counter = 0;
    private int alpha = 3;
    private int beta = 4;
    private int gamma = 4;

    public Earth(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    @Override
    void update() {
        if (Game.state == Game.state.GAME_OVER) {
            moveAround();
        }
    }

    public void moveAround() {
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
        Color a = new Color(255, 255, 255, alpha);
        g.setColor(a);
        g.drawString("The aliens are gone.", 60, 177);

        if (y < 430) {
            if (alpha < 220) {
                alpha += 2;
            }
        }

        if (y < 375) {
            if (beta < 220) {
                beta += 2;
            }
        }

        Color b = new Color(255, 255, 255, beta);
        g.setColor(b);
        g.drawString("You have saved Earth.", 60, 198);

        if (offScreen) {
            if (gamma < 220) {
                gamma += 4;
            }
            Color c = new Color(255, 255, 255, gamma);
            g.setColor(c);
            g.drawString("Thank you for playing.", 102, 400);
        }
    }
}




