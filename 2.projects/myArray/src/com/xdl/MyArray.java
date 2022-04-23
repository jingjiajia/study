package com.xdl;

import java.util.Arrays;

public class MyArray {
    private int[] elements;
    //聲明一個可變長度的數組
    public MyArray(){
         elements = new int[0];
    }
    //0.size()
    public int size(){
        return elements.length;
    }
    //1.增加元素到數組的末尾
    public void addElement(int element){
        int[] newArray = new int[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = element;
        elements = newArray;
    }
    // 2.打印所有元素到控制臺
    public void show(){
        System.out.println(Arrays.toString(elements));
    }
    //3.delete()
    public void delete(int index){
        if(index < 0 || index > elements.length-1){
            throw new RuntimeException("越界");
        }
        int[] newArray = new int[elements.length-1];
        for (int i = 0; i < newArray.length;i++){
            if( i < index){
                newArray[i] = elements[i];
            }else{
                newArray[i] = elements[i+1];
            }
        }
        elements = newArray;
    }
}
