package com.jingjiajia.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestRepeated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String word = scanner.nextLine();
            int length = getWordLength(word);
            System.out.println(length);
        }
        scanner.close();
    }
    public static int getWordLength(String word){
        if ("".equals(word) || null==word){
            return 0;
        }
        char[] chars = word.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        System.out.println(Arrays.toString(set.toArray()));
        return set.toArray().length;
    }
}
