package com.thanksotnica.dp.factory.v4;

/**
 * Created by thankstonica on 2020/9/15.
 */
public class CarFactory {
    public Movable create(){
        return new Car();
    }

    private CarFactory(){}

    private static CarFactory INSTANCE = new CarFactory();

    public static CarFactory getInstance(){
        return INSTANCE;
    }
}
