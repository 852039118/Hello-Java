package com.warren.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.warren.reflection.User");

        User user = new User();
        c1 = user.getClass();

        //获得类的名字
        System.out.println(c1.getName());       //包名 + 类名
        System.out.println(c1.getSimpleName()); //类名

        Field[] fields = c1.getFields();    //只能找到public属性

        fields  = c1.getDeclaredFields();//找到全部属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("=====getMethods=====");
        //获得类的方法
        Method[] methods = c1.getMethods(); //获得本类及其父类的所有public方法
        for (Method method : methods) {
            System.out.println("正常的" + method);
        }
        System.out.println("=====getDeclaredMethods=====");
        methods = c1.getDeclaredMethods();  //获得本类的所有方法
        for (Method method : methods) {
            System.out.println(method);
        }
        //获得指定方法
        Method getName = c1.getMethod("getName",null);
        Method getName2 = c1.getMethod("setName", String.class);
        System.out.println("指定方法" + getName);
        System.out.println("指定方法" + getName2);

        //获得构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("#" + constructor);
        }

        //获得指定的构造器
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println("指定的构造器" + constructor);
    }
}
