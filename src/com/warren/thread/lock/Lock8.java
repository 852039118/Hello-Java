package com.warren.thread.lock;
/*
* 8锁：就是关于锁的8个问题
* 1、
*
*
* */
public class Lock8 {
    public static void main(String[] args) {

    }
}
class Phone{
    // 没有synchronized，不参与锁
    void A(){

    }

    // 锁的是this，调用对象
    synchronized void B(){

    }

    // 锁的是class模板，和this的锁互不影响
    static synchronized void C(){

    }
}
