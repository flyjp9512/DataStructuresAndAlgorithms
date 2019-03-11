package com.flyjp.dsaa;

/**
 * 选择排序
 * 选择排序法是将序列分为两段，有序前列和无序后列，每次查找无序后列中最大元素，将其插入到有序前列的最末尾处，
 * 直至无序后列最后一个元素，最终排序后的序列为降序序列
 */
public class SelectionSort {

    public static void main(String[] args){
        long[] arr = {34,23,2,1,-4};
        System.out.println("排序前："+Util.print(arr));
        arr = sort(arr);
        System.out.println("排序后："+Util.print(arr));

    }

    public static long[] sort(long[] arr){
        int k = 0;
        long tmp = 0;
        for(int i = 0 ; i < arr.length - 1; i++){
            k = i;
            for(int j = i ; j < arr.length ; j++){
                if(arr[j] < arr[k]){
                    k = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
        return arr;
    }
}
