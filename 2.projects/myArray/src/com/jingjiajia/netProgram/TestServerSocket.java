package com.jingjiajia.netProgram;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int res = dataInputStream.read();
            System.out.println(res);
            serverSocket.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
