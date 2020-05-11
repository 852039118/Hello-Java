package com.warren.annotation;

import java.util.ArrayList;
import java.util.List;

//测试 内置注解
public class Test01 extends Object{

    //@Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test(){
        System.out.println("这是一个废弃注解");
    }

    //@SuppressWarnings("all")  镇压警告
    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
