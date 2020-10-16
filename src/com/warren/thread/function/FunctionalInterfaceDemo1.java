package com.warren.thread.function;

import java.util.function.Function;

/**
 * 函数式接口 Function, 有一个输入参数，有一个输出
 * 只要是 函数型接口 可以 用 lambda表达式简化
 */
public class FunctionalInterfaceDemo1 {
    public static void main(String[] args) {
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String str) {
//                return str.toUpperCase();
//            }
//        };

        // lambda表达式 简写
        Function<String, String> function = (str)->{ return str.toUpperCase(); };

        System.out.println(function.apply("asd"));
    }
}
