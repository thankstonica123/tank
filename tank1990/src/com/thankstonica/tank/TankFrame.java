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

    int x = 200,y = 200;

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
        g.fill3DRect(x,y,50,50,false);
        System.out.println("paint ...");
        x += 5;
    }

    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            //x += 2;
            //repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released ..");
        }
    }
}
