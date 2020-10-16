package com.warren.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (Iterator iterater = list.iterator(); iterater.hasNext();){
            System.out.println(iterater.next());
        }

        System.out.println("-----Java8之后-----");

        list.forEach(v -> {
            System.out.println(v);
        });
    }
}
