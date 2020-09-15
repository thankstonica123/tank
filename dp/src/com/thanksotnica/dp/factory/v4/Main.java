package com.thanksotnica.dp.factory.v4;

/**
 * Created by thankstonica on 2020/9/15.
 */
public class Main {
    public static void main(String[] args) {
        CarFactory.getInstance().create().go();
    }
}
