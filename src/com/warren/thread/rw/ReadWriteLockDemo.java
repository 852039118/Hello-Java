package com.warren.thread.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁） 一次只能被一个线程占有
 * 共享锁（读锁） 多个线程可以同时占有
 * ReadWriteLock
 * 读-读  可以共存
 * 读-写  不可共存
 * 写-写  不可共存
 * ReadWriteLock lock = new ReentrantReadWriteLock();
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyClassLock myClass = new MyClassLock();

        // 读
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myClass.setMap(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        // 取
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myClass.getMap(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
// 自定义缓存 + 读写锁
class MyClassLock{
    private volatile Map<String,Object> map = new HashMap();
    // 读写锁
    ReadWriteLock lock = new ReentrantReadWriteLock();

    // 写入，只允许有一个线程执行
    public void setMap(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " 写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    // 读取，允许多个线程同时读取
    public void getMap(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}

// 自定义缓存
class MyClass{
    private volatile Map<String,Object> map = new HashMap();

    // 写入
    public void setMap(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 写入" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + " 写入OK");
    }

    // 读取
    public void getMap(String key) {
        System.out.println(Thread.currentThread().getName() + " 读取" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取OK");
    }
}
