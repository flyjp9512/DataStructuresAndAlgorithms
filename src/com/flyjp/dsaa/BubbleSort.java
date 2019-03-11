package com.flyjp.dsaa;

/**
 * 冒泡排序
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 */
public class BubbleSort {

    public static void main(String[] args){
        long[] arr = {34,23,2,1,-4};
        System.out.println("排序前："+Util.print(arr));
        arr = sort(arr);
        System.out.println("排序后："+Util.print(arr));


    }

    public static long[] sort(long[] arr){
        long tmp = 0;
        for(int i = 0 ; i <arr.length - 1; i++){
            for(int j = arr.length - 1 ; j > i ; j--){
                if(arr[j] < arr[j-1]){
                    //进行交换
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return arr;
    }
}
