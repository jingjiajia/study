package com.jingjiajia.demo;

public class SubThreadTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法"+i);
        }
    }

    public static void main(String[] args) {
        Thread thread= new SubThreadTest();
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("---main方法"+i);
        }
    }
//    public int getWordLength(String word){
//        return 0;
//    }

}
