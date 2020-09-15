package com.thankstonica.dp.proxy.v4;

/**
 * Created by thankstonica on 2020/9/13.
 */
public class TankTimeProxy extends Tank implements Movable{

    Movable m ;

    public TankTimeProxy( Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start:"+start);
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("end:"+end);
        System.out.println("tank moved tiem:"+(end-start));
    }
}
