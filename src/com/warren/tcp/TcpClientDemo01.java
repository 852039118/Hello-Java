package com.warren.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
//TCP实现聊天
public class TcpClientDemo01 {
    public static void main(String[] args){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. 要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("localhost");
            int port = 9999;
            //2. 创建一个socket连接
            socket = new Socket(serverIP,port);
            //3. 发送消息 IO流
            os = socket.getOutputStream();
            os.write("你好，TCP服务器".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //关闭资源
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
