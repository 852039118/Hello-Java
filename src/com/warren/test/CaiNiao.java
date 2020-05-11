package com.warren.test;

import java.util.UUID;

public class CaiNiao {

    public static void test1(){
        boolean b;  //默认值 false
        float f;    //默认值 0.0f
        char c = 65;
        System.out.println("c = "+c);
    }

    public static void f(String s){
        System.out.println("String" + s);
    }
    public static void f(Integer i){
        System.out.println("Integer" + i);
    }

    public static void g(Integer i){
        System.out.println("Integer" + i);
    }
    public static void g(double d){
        System.out.println("String" + d);
    }
    <String, T, Alibaba> String get(String string, T t) { return string; }



    public static void main(String[] args) {
        String s1 = "runoob";
        String s2 = "runoob";
        System.out.println("s1 == s2 is:" + s1 == s2);//因为在 Java 中 + 操作法的优先级大于 ==，所以输出部分表达式等于 “s1 == s2 is:runoob” == “runoob”，该表达式计算结果为 false
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = new String("runoob");
        String s4 = new String("runoob");
        System.out.println(s3 == s4);   //false 比较的是地址 s3 和 s4 指向的地址不一样
        System.out.println(s3.equals(s4));  //true 比较的是值
        test1();
//        f(null);  //编译出错，因为null是一个对象，String和Integer都是对象，不知道调用谁
        g(1);   //1是一个常量，Integer是一个对象

        //uuid
        String uuid = UUID.randomUUID().toString();
        System.out.println("随机唯一识别的通用码uuid : " + uuid); //6f43cd7-3091-440f-8255-f51d32b88f87

        String a = null; switch(a){
            case "null" :   System.out.println("null");break;

        }
    }

}
