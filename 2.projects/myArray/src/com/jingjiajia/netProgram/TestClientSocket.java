package com.jingjiajia.netProgram;

import java.io.DataOutputStream;
import java.net.Socket;

public class TestClientSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.8",8888);
            System.out.println("客户端连接成功");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.write(123);
            socket.close();
            dataOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
