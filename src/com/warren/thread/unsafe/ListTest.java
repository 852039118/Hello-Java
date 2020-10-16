package com.warren.thread.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
/*
         并发下ArrayList不安全、
         解决方案：
         1、Vector<String> list = new Vector<>();                                // JDK1.0就有了 synchronized
         2、List<String> list = Collections.synchronizedList(new ArrayList<>()); // 集合工具类
         3、List<String> list = new CopyOnWriteArrayList<>();                    // lock锁 + CopyOnWrite
*/
/*
         CopyOnWriteArrayList 比 Vector 好在哪？
         1. Vector用的是Synchronized，效率低
         2. CopyOnWriteArrayList用的是lock锁，源码是 先复制数组到一个长度加1的新数组，把新增元素放到末尾，再返回新数组。
*/

//        List<String> list = new ArrayList<>();    // （JDK1.2出的）
        List<String> list = new CopyOnWriteArrayList<>();

        System.out.println(UUID.randomUUID().toString().substring(0,5));

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                },String.valueOf(i)).start();
            System.out.println(list);
        }
    }
}
