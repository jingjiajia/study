package com.jingjiajia.netProgram;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServerString {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("客户端:"+socket.getInetAddress()+"连接成功");
                new ServerThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
