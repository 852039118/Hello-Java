package com.warren.thread.pool;

import java.util.concurrent.*;

/**
 * 3大方法：工作中不允许使用
 *      Executors.newSingleThreadExecutor()
 *      Executors.newFixedThreadPool(5)
 *      Executors.newCachedThreadPool()
 *
 * 7大参数：用ThreadPoolExecutor来自定义线程池
 *      int corePoolSize,                           // 核心线程池大小
 *      int maximumPoolSize,                        // 最大核心线程池大小
 *      long keepAliveTime,                         // 超时了没有人调用就会释放
 *      TimeUnit unit,                              // 超时单位
 *      BlockingQueue<Runnable> workQueue,          // 阻塞队列
 *      ThreadFactory threadFactory,                // 线程工厂：创建线程的，一般不用动
 *      RejectedExecutionHandler handle             // 拒绝策略
 *
 *
 * 4种拒绝策略：线程数超过了最大承载，有4种拒绝策略
 *      new ThreadPoolExecutor.AbortPolicy()         抛出异常
 *      new ThreadPoolExecutor.CallerRunsPolicy()    不抛出异常，哪来的去哪里，由main执行
 *      new ThreadPoolExecutor.DiscardPolicy()       不抛出异常，队列满了，丢掉任务
 *      new ThreadPoolExecutor.DiscardOldestPolicy() 不抛出异常，队列满了，尝试和最早的线程竞争，失败则丢掉任务
 *
 * 最大承载：maxPoolSize + blockingQueue   最大核心线程池大小 + 阻塞队列
 */
public class _3Methods {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();             // 单个线程
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);  // 创建一个固定大小的线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();           // 可伸缩的、 遇强则强，遇弱则弱
        /**
         * 阿里开发手册声明：如上所示，不允许使用Executors去创建线程池，防止资源被耗尽。
         *  newSingleThreadExecutor和newFixedThreadPool允许请求的队列长度为Integer.MAX_VALUE,可能会堆积大量的请求，导致OOM
         *  newCachedThreadPool 允许创建的线程数量为Integer.MAX_VALUE，可能会创建大量的线程，导致OOM
         *
         *  建议使用原生的ThreadPoolExecutor的方法创建线程池（7大参数、4种拒绝策略），如下：
         */

        // 获取系统CPU的核数（逻辑处理器）
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 自定义线程池
        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
                2,      // 核心线程池大小  corePoolSize
                Runtime.getRuntime().availableProcessors(),  // 最大核心线程池大小 maxPoolSize
                0L,    // 超时了没有人调用就会被释放 keepAliveTime
                TimeUnit.SECONDS,    // 时间单位
                new ArrayBlockingQueue<>(5),    // 阻塞队列
                Executors.defaultThreadFactory(),        // 线程工厂: 创建线程的，一般不用动
                new ThreadPoolExecutor.DiscardOldestPolicy()     // 拒绝策略（4种）
        );

        /**
         * 如果超过了最大承载，有4种拒绝策略：
         * new ThreadPoolExecutor.AbortPolicy()         抛出异常
         * new ThreadPoolExecutor.CallerRunsPolicy()    不抛出异常，哪来的去哪里，由main执行
         * new ThreadPoolExecutor.DiscardPolicy()       不抛出异常，队列满了，丢掉任务
         * new ThreadPoolExecutor.DiscardOldestPolicy() 不抛出异常，队列满了，尝试和最早的线程竞争，失败则丢掉任务
         */

        try {
            // 最大承载：maxPoolSize + blockingQueue   最大核心线程池大小 + 阻塞队列
            for (int i = 1; i <= 10; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                myThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            myThreadPool.shutdown();
        }

    }
}
