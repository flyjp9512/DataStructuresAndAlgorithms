package com.flyjp.dsaa;

/**
 * 递归 三角形
 */
public class TestRecursionTriangle {

    public static void main(String[] args){
        System.out.println(RecursionTriangle.getNumber(500));//125150
        System.out.println(RecursionTriangle.getNumberByRecursion(500));//125250
    }

}

 class RecursionTriangle{

    public static int getNumber(int n){
        int total =0;
        while(n > 0){
            total += n;
            n--;
        }
        return total;
    }


    public static int getNumberByRecursion(int n ){
        if(n == 1){
            return 1;
        }else{
            return n + getNumberByRecursion(n - 1);
        }
    }
}
