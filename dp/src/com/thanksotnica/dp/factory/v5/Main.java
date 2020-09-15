package com.thanksotnica.dp.factory.v5;

/**
 * 抽象工厂：实现一次生成一簇产品
 * Created by thankstonica on 2020/9/15.
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new MagicFactory();
        factory.createVehicle().go();
        factory.createWeapon().shoot();
        factory.createFood().printName();
    }
}
