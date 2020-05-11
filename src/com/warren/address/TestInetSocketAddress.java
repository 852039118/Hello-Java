package com.warren.address;

import java.net.InetSocketAddress;

//测试IP
public class TestInetSocketAddress {
    public static void main(String[] args){
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(inetSocketAddress1);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",8080);
        System.out.println(inetSocketAddress2);
    }
}