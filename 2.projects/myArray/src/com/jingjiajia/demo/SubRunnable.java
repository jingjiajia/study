package com.jingjiajia.demo;

public class SubRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("run方法中的i:"+i);
        }
    }
    public static void main(String[] args) {
        Runnable runnable = new SubRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("-----main方法的i："+i);
        }
    }
}
