package com.xdl;

import java.util.Scanner;

public class testNumCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //加入个判断，执行多个用例
        while(sc.hasNext()){
            String str = sc.nextLine();
            int aTozCount = 0;
            int spaceCount = 0;
            int numerCount = 0;
            int otherCount = 0;
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||
                        (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                    aTozCount++;
                } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    numerCount++;
                } else if (str.charAt(i) == ' ') {
                    spaceCount++;
                } else {
                    otherCount++;
                }
            }
            System.out.println(aTozCount);
            System.out.println(spaceCount);
            System.out.println(numerCount);
            System.out.println(otherCount);
        }
        sc.close();
    }
}
