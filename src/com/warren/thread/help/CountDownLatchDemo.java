package com.warren.thread.help;

import java.util.concurrent.CountDownLatch;

// 常用辅助类1：减法器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 初始值6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " go out");
                countDownLatch.countDown(); // 减一
            },String.valueOf(i)).start();
        }
        // 一直等待CountDownLatch的值变为0才执行后面的，相当于while
        countDownLatch.await();

        System.out.println("关门咯！");
    }
}
