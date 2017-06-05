package alien_attack;

import java.awt.*;

/**
 * Created by frances on 2016-12-25.
 */
public abstract class GameObject {

    protected int x;
    protected int y;
    protected int width;
    protected int height = 10;
    protected Image img;
    protected Rectangle rect;

    GameObject(int x, int y, int width, int height, Image img){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.rect = new Rectangle(x, y, width, height);
    }

    abstract void update();
    abstract void draw(Graphics g);

    public int getX() {
        return x;
    }
    public void setX(int pos) {
        x = pos;
    }
    public int getY() {
        return y;
    }
    public void setY(int pos) {
        y = pos;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
}
