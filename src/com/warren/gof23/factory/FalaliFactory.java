package com.warren.gof23.factory;

public class FalaliFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Falali();
    }
}
