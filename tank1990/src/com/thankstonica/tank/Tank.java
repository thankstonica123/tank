package com.thankstonica.tank;

import java.awt.*;

/**
 * Created by thankstonica on 2020/9/10.
 */
public class Tank {

    private int x,y;

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    private Direction dir = Direction.DOWN;
    private static final int SPEED = 10;

    public Tank(int x,int y,Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public void paint(Graphics g) {
        g.fill3DRect(x,y,50,50,false);
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
