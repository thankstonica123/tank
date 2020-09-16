package com.thankstonica.tank;

import java.awt.*;

/**
 * Created by thankstonica on 2020/9/10.
 */
public class Tank {

    private int x,y;
    private Direction dir = Direction.UP;
    private TankFrame tf ;
    private static final int SPEED = 5;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private boolean moving = false;



    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Tank(int x,int y,Direction dir,TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        //g.setColor(Color.BLUE);
        //g.fill3DRect(x,y,50,50,false);
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,this.x,this.y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,this.x,this.y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,this.x,this.y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,this.x,this.y,null);
                break;
        }

        move();

    }

    private void move() {
        if(!moving) return;

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

    public void file(){
       this.tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));
    }
}
