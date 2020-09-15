package com.thanksotnica.dp.factory.v5;

/**
 * Created by thankstonica on 2020/9/15.
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Mashroom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
