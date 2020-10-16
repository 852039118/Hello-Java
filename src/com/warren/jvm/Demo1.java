package com.warren.jvm;

import java.util.Random;

/**
 * java.lang.OutOfMemoryError: Java heap space 内存溢出
 *
 * -Xms8m -Xmx8m -XX:+PrintGCDetails 自定义堆中新生区和养老区的空间
 *                                      元空间逻辑上在堆里，但物理上不在堆里
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "Warren";
        while(true){
            str += str + new Random().nextInt(999999999) + new Random().nextInt(999999999);
        }
    }
}
