package com.thankstonica.dp.proxy.v5;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * question:how to record tank moving time ?
 * 修改源代码？
 * 如果不能修改源代码呢？ benchmark
 * 最笨的方法是继承一个tank，但是不好，不好扩展，比如加上log校验，权限校验
 * jdk 动态代理
 * Created by thankstonica on 2020/9/7.
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank is moving ka ka ka ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        Movable m = (Movable)Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("tank is starting ....");
                method.invoke(tank,args);
                System.out.println("tank stopped ...");
                return proxy;
            }
        });

        m.move();

    }
}




















