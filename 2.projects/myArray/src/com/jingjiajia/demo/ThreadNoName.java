package com.jingjiajia.demo;

public class ThreadNoName {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("thread + 匿名内部类");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable + 匿名内部类");
            }
        }).start();

    }
}
