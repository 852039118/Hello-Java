package com.warren.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
* Lock 测试
* */

/**
 * Synchronized和Lock比较
 *  Synchronized是关键字，内置语言实现，Lock是接口。
 *  Synchronized在线程发生异常时会自动释放锁，因此不会发生异常死锁。Lock异常时不会自动释放锁，所以需要在finally中实现释放锁。
 *  Lock是可以中断锁，Synchronized是非中断锁，必须等待线程执行完成释放锁。
 *  Lock可以使用读锁提高多线程读效率。
 */
public class LockTest {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.getTicket(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.getTicket(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.getTicket(); },"C").start();
    }
}

class Ticket{
    private int num = 100;

    private Lock lock = new ReentrantLock();

    public void getTicket(){
        while (num >= 0){

            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "获得了第" + (num--));
            }catch (Exception e){
                e.printStackTrace();
            } finally{
                lock.unlock();
            }

            // 模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


