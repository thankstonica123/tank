package com.thankstonica.tank;

/**
 * Created by thankstonica on 2020/9/10.
 */
public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }
    }
}
