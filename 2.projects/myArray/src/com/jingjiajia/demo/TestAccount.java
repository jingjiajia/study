package com.jingjiajia.demo;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1000);
        Thread thread = new Thread(account);
        Thread thread1 = new Thread(account);
        thread.start();
        thread1.start();
        System.out.println("主线程等待子线程终止");
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的账户余额是："+account.getMoney());
    }
}
