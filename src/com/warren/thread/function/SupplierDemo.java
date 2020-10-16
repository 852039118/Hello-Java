package com.warren.thread.function;

import java.util.function.Supplier;

/**
 * 供给型接口:Supplier 没有参数，只有返回值
 */
public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "hello FunctionalInterface";
//            }
//        };

        Supplier<String> supplier = ()->{ return "hello FunctionalInterface"; };

        System.out.println(supplier.get());
    }
}
