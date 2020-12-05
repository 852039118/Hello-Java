package com.warren.thread.stream;

import java.util.stream.LongStream;

/**
 * Stream并行计算的威力
 *      计算1~10亿的递归求和
 */
public class computeTest {
    public static void main(String[] args) {
        test1();    // sum=500000000500000000时间：787
//        test2();    // sum=500000000500000000时间：396
    }

    //  普通程序员
    public static void test1(){
        long start = System.currentTimeMillis();
        long sum = 0;

        for (long i = 0; i <= 10_0000_0000; i++) {
            sum += i;
        }

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间：" + (end - start));
    }

    // stream并行流计算
    public static void test2(){
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间：" + (end - start));
    }
}
