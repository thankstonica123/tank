package com.thankstonica.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thankstonica on 2020/9/6.
 */
public class TankFrame extends Frame{

    // 坦克初始位置
    // int x = 200,y = 200;
    // new 出自己的tank
    Tank tank = new Tank(200,200,Direction.DOWN,this);
    Bullet bullet = new Bullet(300,300,Direction.DOWN,this);
    List<Bullet> bullets = new ArrayList<Bullet>();

    // 坦克速度
    // public static final int SPEED = 10;

    // 坦克方向
    // Direction dir = Direction.DOWN;

    public static int GAME_WIDTH = 800,GAME_HEIGHT = 600;

    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        this.setTitle("TankWar1990");
        this.setResizable(false);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        // tank 能更好地知道如何画自己
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("字段数量："+this.bullets.size(),10,50);
        g.setColor(color);
        tank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }


    }

    // 双缓冲消除闪烁
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    class MyKeyListener extends KeyAdapter{

        boolean bR = false;
        boolean bD = false;
        boolean bL = false;
        boolean bU = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode){
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.file();
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bR && !bD && !bL && !bU){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(bR) tank.setDir(Direction.RIGHT);
                if(bD) tank.setDir(Direction.DOWN);
                if(bL) {
                    tank.setDir(Direction.LEFT);
                }
                if(bU) {
                    tank.setDir(Direction.UP);
                }
            }

        }
    }
}
