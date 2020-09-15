package com.thanksotnica.dp.factory.v5;

/**
 * Created by thankstonica on 2020/9/15.
 */
public class ModernFactory extends AbstractFactory {

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }
}
