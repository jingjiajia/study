package com.jingjiajia.demo;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            String str = sc.nextLine();
//            先便利字符串中每个元素，然后放入set集合去重
            for (int i = 0; i < str.length(); i++) {
                Character cc = str.charAt(i);
                set.add(cc);
            }
            list.addAll(set);
//            便利每一个字符，然后找到对应字符出现的次数，并且放入map集合
            for (int i = 0; i < list.size(); i++) {
                Character c = list.get(i);
                String newStr = str.replaceAll(c+"","");
                count = (str.length()-newStr.length())/(c+"").length();
                map.put(c,count);
            }
            List<Integer> countList = new ArrayList<>();
//            便利map集合，找到对应的次数，转换为list集合
            for (Map.Entry<Character,Integer> entry: map.entrySet()){
                int value = entry.getValue();
                Character c = entry.getKey();
                countList.add(value);
            }
            // 把出现的次数放到数组中，并找出最小值，然后通过map删除
            Integer[] countArray = new Integer[countList.size()];
            Integer[] newCountArray = countList.toArray(countArray);
            int min = newCountArray[0];
            for (int i = 0; i < newCountArray.length; i++) {
                if (min > newCountArray[i]){
                    min = newCountArray[i];
                }
            }
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                int value = entry.getValue();
                if (value == min){
                    str = str.replaceAll((entry.getKey()+""),"");
                }
            }
            System.out.println(str);
        }
    }
}
