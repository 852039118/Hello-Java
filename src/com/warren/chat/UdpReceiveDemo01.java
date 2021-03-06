package com.warren.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(7777);

        while (true){
            //准备接收数据
            byte[] container = new byte[1024];

            DatagramPacket packet = new DatagramPacket(container,0,container.length);

            socket.receive(packet); //阻塞式接收数据

            //解析数据
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length);
            System.out.println(receiveData);

            //断开连接
            if (receiveData == "bye"){
                break;
            }
        }
        socket.close();
    }
}
