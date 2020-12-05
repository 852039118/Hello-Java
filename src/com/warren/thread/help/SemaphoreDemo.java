package com.warren.thread.help;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// 常用辅助类3：信号量，抢车位
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量：停车位，限流！！！
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            // acquire() 得到
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // release() 释放
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
