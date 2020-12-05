package com.warren.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* Lock的Condition 测试
* */
public class LockCondition {
    public static void main(String[] args) {

        ConditionTest conditionTest = new ConditionTest();

        new Thread(()->{ for (int i = 0; i < 10; i++) conditionTest.printA(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) conditionTest.printB(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) conditionTest.printC(); },"C").start();
    }
}

class ConditionTest{
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private int flag = 1;
    public void printA(){
        lock.lock();
        try {
            //业务
            while (flag != 1){
                // 等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAA");
            Thread.sleep(100);
            // 唤醒2B
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            //业务
            while (flag != 2){
                // 等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAA");
            // 唤醒2B
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            //业务
            while (flag != 3){
                // 等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAA");
            // 唤醒2B
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


