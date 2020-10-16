package com.warren.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue 同步队列，没有任何内部容量。和其他BlockingQueue不一样，SynchronousQueue不存储元素
 * put了一个元素之后，必须从里面先take取出来，否则不能再put进去
 *      put(E e)   将指定的元素添加到此队列，等待另一个线程接收它。
 *      take(E e)  检索并删除此队列的头，等待另一个线程插入它。
 *
 *      offer(E e)  如果另一个线程正在等待接收，则将指定的元素插入到此队列中。
 *      poll()      如果另一个线程正在使一个元素可用，则检索并删除此队列的头。
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test1() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                blockingQueue.put("a");     // 等这个元素被取出来才会执行后面的
                System.out.println(Thread.currentThread().getName() + "存入了" + "a");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "存入了" + "b");
                blockingQueue.put("c");
                System.out.println(Thread.currentThread().getName() + "存入了" + "c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "=>" + blockingQueue.take());
                System.out.println(Thread.currentThread().getName() + "=>" + blockingQueue.take());
                System.out.println(Thread.currentThread().getName() + "=>" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
