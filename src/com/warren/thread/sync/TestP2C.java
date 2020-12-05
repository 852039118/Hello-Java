package com.warren.thread.sync;
/*
* 生产者(producer) to 消费者(consumer)
* */
public class TestP2C {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}

// 生产者
class Producer extends Thread{

    Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            buffer.push(new Chicken(i));
            System.out.println("生产了第" + i + "只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            Chicken chicken = buffer.pop();
            System.out.println("消费了第" + chicken.getId() + "只鸡");
        }
    }
}

// 缓冲区（交易平台）
class Buffer{
    // 需要一个缓冲区大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产鸡
    public synchronized void push(Chicken chicken){
        // 如果容器满了，
        while (count == chickens.length-1){
            // 通知消费者消费，停止生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果没满，我们就丢入产品
        chickens[count] = chicken;
        count++;

        // 通知消费者消费
        this.notifyAll();

    }

    // 消费鸡
    public synchronized Chicken pop(){
        // 如果没有鸡了
        while(count == 0){
            // 通知生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果还有，就取出产品
        count--;
        Chicken chicken = chickens[count];

        // 通知生产者生产
        this.notifyAll();

        return chicken;
    }
}

// 产品：鸡
class Chicken{
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
