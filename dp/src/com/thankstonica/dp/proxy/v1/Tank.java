package com.thankstonica.dp.proxy.v1;

import java.util.Random;

/**
 * question:how to record tank moving time ?
 * Created by thankstonica on 2020/9/7.
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank is moving ka ka ka ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
