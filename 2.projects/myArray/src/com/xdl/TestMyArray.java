package com.xdl;

public class TestMyArray {
    public static void main(String[] args) {
        MyArray ma = new MyArray();
        int size = ma.size();
        System.out.println(size);
        System.out.println("------------------------");
        ma.addElement(99);
        size = ma.size();
        System.out.println(size);
        System.out.println("-------------------------");
        ma.addElement(98);
        ma.addElement(8);
        ma.show();
        System.out.println("---------------------------");
        ma.addElement(100);
        ma.addElement(97);
        ma.delete(1);
        ma.show();
    }
}
