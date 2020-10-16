package com.warren.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue 单向阻塞队列（初始构造容量 FIFO）
 *  peek() 查看队首元素
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 会抛异常
     * API： add()、remove()、
     */
    public static void test1(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c")); // true
//        System.out.println(blockingQueue.add("d")); // 异常：java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove()); // 异常：java.util.NoSuchElementException
    }

    /**
     * 不会抛异常,不阻塞，返回值：false、null
     * API： offer()、poll()
     */
    public static void test2(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));   // true
        System.out.println(blockingQueue.offer("b"));   // true
        System.out.println(blockingQueue.offer("c"));   // true
        System.out.println(blockingQueue.offer("d"));   // false,不会抛异常

        System.out.println(blockingQueue.poll());   // a
        System.out.println(blockingQueue.poll());   // b
        System.out.println(blockingQueue.poll());   // c
        System.out.println(blockingQueue.poll());   // null,不会抛异常

    }

    /**
     * 持续阻塞，返回值：false、null
     * API： put()、take()
     */
    public static void test3() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");   // 持续阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());   // 持续阻塞

    }

    /**
     * 不会抛异常,设置阻塞的超时时间
     * API： offer(,,)、poll(,)
     */
    public static void test4() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));   // true
        System.out.println(blockingQueue.offer("b"));   // true
        System.out.println(blockingQueue.offer("c"));   // true
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));   // false,阻塞 等待超时时间2s

        System.out.println(blockingQueue.poll());   // a
        System.out.println(blockingQueue.poll());   // b
        System.out.println(blockingQueue.poll());   // c
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));   // null,阻塞 等待超时时间2s
    }
}
