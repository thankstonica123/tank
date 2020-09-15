package com.thankstonica.dp.proxy.v4;

import java.util.Random;

/**
 * question:how to record tank moving time ?
 * 修改源代码？
 * 如果不能修改源代码呢？ benchmark
 * 最笨的方法是继承一个tank，但是不好，不好扩展，比如加上log校验，权限校验
 * 使用聚合，使代理也实现movable
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

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
        System.out.println("================================================");
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}
