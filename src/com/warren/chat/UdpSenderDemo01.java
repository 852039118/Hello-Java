package com.warren.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8080);
        while(true){
            //准备数据，控制台读取 System.in
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            byte[] datas = data.getBytes();

            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",7777));

            socket.send(packet);

            //断开连接
            if (data == "bye"){
                break;
            }
        }
        socket.close();
    }
}
