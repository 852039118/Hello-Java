package com.warren.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloword/index.jsp?username=wkj&password=123");
        System.out.println("协议:     " + url.getProtocol());
        System.out.println("主机ip:   " +url.getHost());
        System.out.println("端口:     " +url.getPort());
        System.out.println("文件:     " +url.getPath());
        System.out.println("全路径:    " +url.getFile());
        System.out.println("参数:      " +url.getQuery());
    }
}
