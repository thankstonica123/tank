package com.thanksotnica.dp.factory.v5;

/**
 * Created by thankstonica on 2020/9/15.
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
