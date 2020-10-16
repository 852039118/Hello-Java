package com.warren.thread;

// 龟兔赛跑案例
public class Race implements Runnable {

    // 冠军
    private String winner;

    @Override
    public void run() {
            for (int i = 1; i <= 100; i++) {
                if (winner == null){
                    System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");

                    // 判断是否跑完了
                    if (i>= 100){
                        winner = Thread.currentThread().getName();
                        System.out.println(winner + "赢得了比赛");
                    }

                    // 兔子每跑20步休息10ms
                    if (Thread.currentThread().getName().equals("兔子") && i%20 == 0){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else break;
            }
    }

    public static void main(String[] args) {
        Race race = new Race();

        // 开启线程
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
