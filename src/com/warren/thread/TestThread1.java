package com.warren.thread;

public class TestThread1 extends Thread{

    //创建线程方式一：继承Thread类，重写run方法，调用start方法开启线程

    //总结：注意，线程不一定立即执行，由CPU调度

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在run=========" + i);
        }
    }

    public static void main(String[] args) {

        //开启一个线程
        new TestThread1().start();

        //主线程
        for (int i = 0; i < 500; i++) {
            System.out.println("我在main=========" +i);
        }
    }
}
