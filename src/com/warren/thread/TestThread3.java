package com.warren.thread;

// 创建线程方式2： 实现Runnable接口,重写run方法
public class TestThread3 implements Runnable{
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("你在干什么" + i);
        }
    }

    public static void main(String[] args){
        // 创建实现了Runnable接口的实例
        TestThread3 testThread3 = new TestThread3();

        new Thread(testThread3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("创建一个线程" + i);
        }
    }
}
