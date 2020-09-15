package com.thanksotnica.dp.factory.v1;

/**
 * 需要变换交通工具需要变更代码
 * Created by thankstonica on 2020/9/15.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();
        Plane plane = new Plane();
        plane.go();
    }
}
