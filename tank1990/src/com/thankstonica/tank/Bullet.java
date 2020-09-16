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
    Boolean live = true;
    TankFrame tf = null;

    public Bullet(int x, int y, Direction dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
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
        if(x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) live = false;
        if(!live){
            tf.bullets.remove(this);
        }

    }
}
