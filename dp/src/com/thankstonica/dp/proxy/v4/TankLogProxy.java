package com.thankstonica.dp.proxy.v4;

/**
 * Created by thankstonica on 2020/9/13.
 */
public class TankLogProxy implements Movable {
    Movable m ;

    public TankLogProxy( Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("tank is starting ... ");
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("tank stopped ...");
    }
}
