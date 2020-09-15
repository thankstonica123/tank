package com.thanksotnica.dp.factory.v3;

/**
 * 简单工厂，可扩展性不好
 * 添加新的交通工具时，需要修改类
 * Created by thankstonica on 2020/9/15.
 */
public class SimpleVehicleFactory {
    public Car creatCar(){
        // 前置处理(权限等)
        return new Car();
    }
}
