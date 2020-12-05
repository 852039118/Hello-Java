package com.warren.gof23.factory;



public class Consumer {
    public static void main(String[] args) {
        Car car = new WulingFactory().getCar();
        Car car2 = new FalaliFactory().getCar();
        Car car3 = new BMWFactory().getCar();
        car.name();
        car2.name();
        car3.name();
    }
}
