package com.thankstonica.dp.proxy.v2;

import java.util.Random;

/**
 * question:how to record tank moving time ?
 * 修改源代码？
 * 如果不能修改源代码呢？
 * Created by thankstonica on 2020/9/7.
 */
public class Tank implements Movable {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tank is moving ka ka ka ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("tank moved tiem:"+(end-start));
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}
