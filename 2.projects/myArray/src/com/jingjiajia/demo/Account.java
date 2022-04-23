package com.jingjiajia.demo;

public class Account implements Runnable{
    private int money;
    private final Test test = new Test();
    public Account() {
    }

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money >= 0){
            this.money = money;
        }else {
            System.out.println("你的余额不足，请仔细核对后再进行操作");
        }
    }

    @Override
    public void run() {
        System.out.println("当前线程是"+Thread.currentThread().getName());
        synchronized (test){
            int temp = getMoney();
            if (money>=200){
                System.out.println("正在出钞中，请稍后.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                temp-=200;
                System.out.println("请取走您的钞票");
            }else{
                System.out.println("余额不足");
            }
            setMoney(temp);
        }
    }

    class Test{}
}
