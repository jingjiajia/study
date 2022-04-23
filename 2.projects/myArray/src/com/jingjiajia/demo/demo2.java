package com.jingjiajia.demo;

import java.util.*;

public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] a = str.toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            for (Character c: a){
                if (!map.containsKey(c)){
                    map.put(c,1);
                }else{
                    map.put(c,map.get(c)+1);
                }
            }
            Collection<Integer> col = map.values();
            int index = Collections.min(col);
            StringBuffer sb = new StringBuffer("");
            for (char c:a){
                if (map.get(c) != index){
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}
