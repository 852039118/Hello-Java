package com.warren.thread.sync;

// 模拟多线程同时访问同一资源
// 购买火车票示例
public class SynchronizedTest implements Runnable {

    // 火车票数量
    private int ticketNums = 10;


    // synchronized 线程同步：队列 + 锁
    // 只锁修改的，不锁只读的，以免影响性能。锁的是this
    @Override
    public synchronized void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }

            System.out.println(Thread.currentThread().getName() +"-->抢到了第" + ticketNums-- + "张票");

            // 模拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest ticket = new SynchronizedTest();

        new Thread(ticket,"小小红").start();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"黄牛党").start();
    }
}
