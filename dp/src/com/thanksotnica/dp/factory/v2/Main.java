package com.thanksotnica.dp.factory.v2;

/**
 * 抽象接口，实现了多态，new 对象可以实现配置化，该代码不需要变动
 * Created by thankstonica on 2020/9/15.
 */
public class Main {
    public static void main(String[] args) {
        Movable m = new Broom();
        m.go();
    }
}
