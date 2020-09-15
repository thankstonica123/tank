package com.thankstonica.tank;

import java.awt.*;

/**
 * Created by thankstonica on 2020/9/15.
 */
public class Bullet {
    private int x,y;
    private final int SPEED = 10;
    private final int WIDTH = 5,HEIGHT =5;
    private Direction dir = Direction.DOWN;

    public Bullet(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        move();

    }

    private void move() {
        switch (dir){
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
        }

    }
}
