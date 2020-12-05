package com.warren.thread.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
/*
    同理可证：并发修改异常java.util.ConcurrentModificationException
    解决方案：
    1、Set<String> set = Collections.synchronizedSet(new HashSet()); // 集合工具类
    2、Set<String> set = new CopyOnWriteArraySet();                  // lock锁 + CopyOnWrite
*/
/*
    HashSet底层是什么？就是HashMap
    public HashSet() {
        map = new HashMap<>();
    }
    add方法：
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
    利用Map的key不可重复，来实现Set的不可重复。PRESENT是不可变常量。
*/

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet();
//        Set<String> set = Collections.synchronizedSet(new HashSet());
//        Set<String> set = new CopyOnWriteArraySet();
        System.out.println(UUID.randomUUID().toString().substring(0,5));
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                    set.add(UUID.randomUUID().toString().substring(0,5));
                },String.valueOf(i)
            ).start();
            System.out.println(set);
        }
    }
}
