package com.warren.gof23.factory;

public class BMWFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new BMW();
    }
}
