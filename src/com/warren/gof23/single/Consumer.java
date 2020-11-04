package com.warren.gof23.single;

public class Consumer {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("五菱");
        Car car2 = CarFactory.getCar("法拉利");

        car.name();
        car2.name();

        Car car3 = CarFactory.getBMW();
        car3.name();
    }
}
