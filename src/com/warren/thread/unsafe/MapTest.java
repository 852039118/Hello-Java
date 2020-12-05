package com.warren.thread.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
    并发修改异常java.util.ConcurrentModificationException
    修改方案：
    1、Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
    2、Map<String,String> map = new ConcurrentHashMap<>();
*/

public class MapTest {
    public static void main(String[] args) {
        // 默认等价于new HashMap(16,0.75)
//        Map<String,String> map = new HashMap<>();
//        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map = new ConcurrentHashMap<>();
        System.out.println(UUID.randomUUID().toString().substring(0,5));
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
            },String.valueOf(i)).start();
            System.out.println(map);
        }
    }
}
