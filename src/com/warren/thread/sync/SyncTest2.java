package com.warren.thread.sync;
// 同步锁代码块
public class SyncTest2 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.getTicket(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.getTicket(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.getTicket(); },"C").start();
    }
}

class Ticket{
    private int num = 100;

    public void getTicket(){
        if (num >= 0){
            // 同步锁代码块
            synchronized(this){
                System.out.println(Thread.currentThread().getName() + "获得了第" + (num--));
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


