package com.warren.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能问题
public class Test09 {

    //普通方式调用
    public static void test01(){
        User user = new User();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("普通方法执行10亿次：" + (endTime - startTime) + "ms");
    }

    //反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class userClass = User.class;
        User user = (User) userClass.newInstance();
        Method getName = userClass.getDeclaredMethod("getName");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方法执行10亿次：" + (endTime - startTime) + "ms");
    }

    //普通方式调用    关闭安全检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class userClass = User.class;
        User user = (User) userClass.newInstance();
        Method getName = userClass.getDeclaredMethod("getName");
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("关闭检测执行10亿次：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        test01();   //6ms
        test02();   //4494ms
        test03();   //1850ms
    }
}
