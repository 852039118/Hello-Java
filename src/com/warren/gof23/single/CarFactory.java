package com.warren.gof23.single;

// 简单工厂模式(静态工厂模式):使用简单，但是新增逻辑会打破OOP原则
public class CarFactory {
    public static Car getCar(String name){
        Car car;
        if (name == "五菱"){
            car = new Wuling();
        }
        else if (name == "法拉利"){
            car = new Falali();
        }
        else car = null;

        return car;
    }

    public static Car getBMW(){
        return new BMW();
    }
}
