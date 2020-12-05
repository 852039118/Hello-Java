package com.warren.thread;

// 模拟多线程同时访问同一资源
// 购买火车票示例
public class TestThread4 implements Runnable {

    // 火车票数量
    private int ticketNums = 10;

    @Override
    public synchronized void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }

            System.out.println(Thread.currentThread().getName() +"-->抢到了第" + ticketNums-- + "张票");

            // 模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket,"小小红").start();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"黄牛党").start();
    }
}
