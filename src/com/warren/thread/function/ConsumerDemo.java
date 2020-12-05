package com.warren.thread.function;

import java.util.function.Consumer;

/**
 * 消费型接口：Consumer，只有输入，没有返回值。
 */
public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };

        Consumer<String> consumer = (str)->{ System.out.println(str); };

        consumer.accept("asd");
    }
}
