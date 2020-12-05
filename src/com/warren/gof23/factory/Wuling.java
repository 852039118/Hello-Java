package com.warren.gof23.factory;

import com.warren.gof23.factory.Car;

public class Wuling implements Car{
    @Override
    public void name() {
        System.out.println("五菱宏光！");
    }
}
