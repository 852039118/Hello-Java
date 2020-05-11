package com.warren.url;

import com.warren.util.SslUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDownFile {
    public static void main(String[] args) throws Exception {

        //1. 下载地址
        //https://img.alicdn.com/tfs/TB1NfdFD79WBuNjSspeXXaz5VXa-80-40.png
        //https://p1.music.126.net/qsRYc_3XeaXUWR1vGnm6vA==/109951164743134727.jpg?param=140y140
        URL url = new URL("https://p1.music.126.net/qsRYc_3XeaXUWR1vGnm6vA==/109951164743134727.jpg?param=140y140");
        //https协议的链接会因为证书问题报错
        //在openConnection前调用该方法,信任所有SSL证书，流批
        SslUtils.ignoreSsl();
        //2. 连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        //写到本地
        FileOutputStream fos = new FileOutputStream("7.jpg");

        byte[] buffer = new byte[1024];

        int len;
        while((len = inputStream.read(buffer)) != -1 ){
            fos.write(buffer,0,len);
        }

        //关闭资源
        fos.close();
    }
}
