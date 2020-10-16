package com.warren.thread.single;

import java.util.concurrent.TimeUnit;

/**
 * volatile:不稳定的
 *      三大特性：
 *              保证可见性：   某个线程上改变了主内存中的这个值，都会马上通知所有线程
 *              不保证原子性： 不能像lock、synchronized那样加锁 保证原子性（原子性：不可分割、打扰）
 *              禁止指令重排：  计算机在编译代码时会给volatile字段前后加上内存屏障，禁止其上下的指令交换。
 *
 *
 *      如果不加 lock 和 synchronized ，怎么样保证原子性？
 *          使用原子类，解决 原子性问题（java.util.concurrent.atomic）
 */
public class VolatileDemo {
    // 不加 volatile 程序就会死循环！
    // 加 volatile 可以保证可见性
    public static volatile int num = 1;

    public static void main(String[] args) {
        new Thread(()->{
            while(num == 1){    // 线程 1 对主内存的变化不知道的

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 0;
        System.out.println(num);
    }
}
