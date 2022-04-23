package com.jingjiajia.netProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TestClientString {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.8",8888);
            Scanner scanner = new Scanner(System.in);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String response = scanner.next();
                printStream.println(response);
                if ("bye".equalsIgnoreCase(response)){
                    break;
                }
                String res = bufferedReader.readLine();
            }
            scanner.close();
            socket.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
