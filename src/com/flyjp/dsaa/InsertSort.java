package com.flyjp.dsaa;

/**
 * 插入排序
 * 算法原理：从整个待排序列中选出一个元素插入到已经有序的子序列中去，得到一个有序的、元素加一的子序列，直到整个序列的待插入元素为0，则整个序列全部有序。
 *
 * 　　在实际的算法中，我们经常选择序列的第一个元素作为有序序列（因为一个元素肯定是有序的），我们逐渐将后面的元素插入到前面的有序序列中，直到整个序列有序。
 */
public class InsertSort {
    public static void main(String[] args){
        long[] arr = {34,23,2,1,-4};
        System.out.println("排序前："+Util.print(arr));
        arr = sort(arr);
        System.out.println("排序后："+Util.print(arr));

    }

    public static long[] sort(long[] arr){
        long tmp = 0;
        for(int i = 1;i < arr.length ; i++){
            tmp = arr[i];
            int j = i;
            while(j > 0 && arr[j] >= tmp){//待排序列中选出一个元素插入到已经有序的子序列中去
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }
}
