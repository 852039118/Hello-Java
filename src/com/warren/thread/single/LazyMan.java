package com.warren.thread.single;

/**
 * 懒汉式单例模式：
 * 1. 私有化构造器
 * 2. 防止指令重排，加上volatile修饰对象
 *          正常步骤：1> 分配内存空间
 *                   2> 调用构造器创建对象
 *                   3> 将对象指向内存空间
 *      万一指令重排，有可能出现1、3、2的执行过程，那么就会直接返回未构造的对象，导致问题
 * 3. 双重检测，并synchronized锁住这个类
 *
 */
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + " OK");
    }

    private volatile static LazyMan lazyMan;
    
    static LazyMan getInstance(){
        if (lazyMan == null){
            // 锁住这个类，防止多线程同时创建
            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}
