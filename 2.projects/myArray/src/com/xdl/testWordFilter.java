package com.xdl;

import java.util.Scanner;

public class testWordFilter {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int i = 0;
        int little = 0;
        int big = 0;
        int num = 0;
        int illegal = 0;
        while(sc.hasNext() && i++ < 100){
            String str = sc.nextLine();
            StringBuilder sb =  new StringBuilder(str);
            if(str.length() < 64){
                for (int j = 0;j < str.length();j++)
                {
                    if (str.charAt(i) > 'a' && str.charAt(i) <'z'){
                        little = 1;
                    } else if(str.charAt(i) > 'A' && str.charAt(i) <'Z'){
                        big = 1;
                    } else if(str.charAt(i) > '0' && str.charAt(i) <'9'){
                        num = 1;
                    } else {
                        illegal = 1;
                    }
                }
                if(illegal == 0){
                    System.out.print(sb + " ");
                } else {
                    System.out.print(sb + " ");
                }
            }
        }
    }
}
