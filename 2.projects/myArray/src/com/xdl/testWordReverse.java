package com.xdl;

import java.util.Scanner;

public class testWordReverse {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder(str);
            if(str.trim().length() > 0){
                System.out.println(sb.reverse());
            }
        }
        sc.close();
    }
}
