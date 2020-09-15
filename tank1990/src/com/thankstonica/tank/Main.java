package com.thankstonica.tank;

/**
 * Created by thankstonica on 2020/9/10.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
