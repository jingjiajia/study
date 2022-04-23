package com.xdl;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        Scanner sc2 = new Scanner(System.in);
        String wordInclude = sc2.nextLine();
        String[] wordArray = words.split("");
        int i = 0;
        for(String word:wordArray){
            if (word.equalsIgnoreCase(wordInclude)){
                i = i+1;
            }
            System.out.println(i);
        }
    }
}
