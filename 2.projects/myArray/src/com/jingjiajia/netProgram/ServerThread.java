package com.jingjiajia.netProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            InetAddress ia = socket.getInetAddress();
            while(true) {
                String res = bufferedReader.readLine();
                System.out.println("客户端"+ ia +"发送的消息是:"+res);
                if ("bye".equalsIgnoreCase(res)){
                    System.out.println("客户端"+ ia +"已下线");
                    break;
                }
                printStream.println("I receive");
            }
            printStream.close();
            socket.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
