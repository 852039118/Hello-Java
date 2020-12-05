package com.warren.gof23.factory;

import com.warren.gof23.factory.Car;

public class BMW implements Car{
    @Override
    public void name() {
        System.out.println("看不到咩，别摸我！");
    }
}
