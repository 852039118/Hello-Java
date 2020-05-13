package com.warren.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.warren.reflection.User");

        //构造一个对象
//        User user = (User) c1.newInstance();    //本质时调用了对象的无参构造器

        //通过构造器创建对象
//        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
//        Object user2 = constructor.newInstance("warren", 001, 18);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getMethod("setName", String.class);
        //invoke：激活的意思
        //（对象，"方法的值"）
        setName.invoke(user3, "reflection-invoke");
        System.out.println(user3);

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user4,"getDeclaredField-set");

        System.out.println(user4);
    }
}
