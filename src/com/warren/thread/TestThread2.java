package com.warren.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread {

    private String url;     //网络图片地址
    private String name;    //保存到本地的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoader(url,name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://warren.run/usr/themes/Typecho-Theme-Aria/assets/img/thumbnail.jpg", "downLoader_1.jpg");
        TestThread2 t2 = new TestThread2("http://warren.run/usr/themes/Typecho-Theme-Aria/assets/img/thumbnail.jpg", "downLoader_2.jpg");
        TestThread2 t3 = new TestThread2("http://warren.run/usr/themes/Typecho-Theme-Aria/assets/img/thumbnail.jpg", "downLoader_3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader方法出现问题！");
        }
    }
}
