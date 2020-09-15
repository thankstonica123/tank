package com.thankstonica.dp.proxy.v3;

/**
 * Created by thankstonica on 2020/9/13.
 */
public class Tank2 extends Tank {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start:"+start);
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("end:"+end);
        System.out.println("tank moved tiem:"+(end-start));
    }
}
