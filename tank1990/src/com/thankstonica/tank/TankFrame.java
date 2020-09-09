package com.thankstonica.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by thankstonica on 2020/9/6.
 */
public class TankFrame extends Frame{

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
    }

    @Override
    public void paint(Graphics g) {
        g.fill3DRect(200,200,50,50,false);
    }
}
