package com.thankstonica.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by thankstonica on 2020/9/6.
 */
public class TankFrame extends Frame{

    // 坦克初始位置
    // int x = 200,y = 200;
    // new 出自己的tank
    Tank tank = new Tank(200,200,Direction.DOWN);

    // 坦克速度
    // public static final int SPEED = 10;

    // 坦克方向
    // Direction dir = Direction.DOWN;

    public TankFrame(){
        this.setSize(800,600);
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
        tank.paint(g);
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
                case KeyEvent.VK_RIGHT:bR = true;break;
                case KeyEvent.VK_DOWN:bD = true;break;
                case KeyEvent.VK_LEFT:bL = true;break;
                case KeyEvent.VK_UP:bU= true;break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_RIGHT:bR = false;break;
                case KeyEvent.VK_DOWN:bD = false;break;
                case KeyEvent.VK_LEFT:bL = false;break;
                case KeyEvent.VK_UP:bU= false;break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(bR) tank.setDir(Direction.RIGHT);
            if(bD) tank.setDir(Direction.DOWN);
            if(bL) tank.setDir(Direction.LEFT);
            if(bU) tank.setDir(Direction.UP);
        }
    }
}
