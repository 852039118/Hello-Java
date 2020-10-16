package com.warren.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("1","11");
        map.put("2","22");
        map.put("3","33");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("-----Java8之后-----");

        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
