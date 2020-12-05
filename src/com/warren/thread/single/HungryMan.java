package com.warren.thread.single;

/**
 * 饿汉式单例
 */
public class HungryMan {

    // 多线程下也可以保证单例不被破坏，但是可能会浪费空间
    private byte[] data1 = new byte[1024*1024];

    // 私有化构造器
    private HungryMan(){}
    // 直接创建静态不可变的私有化对象
    private final static HungryMan HUNGRYMAN = new HungryMan();
    // 返回对象的方法
    static HungryMan getInstance(){
        return HUNGRYMAN;
    }
}
