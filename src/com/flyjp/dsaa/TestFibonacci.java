package com.flyjp.dsaa;

public class TestFibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci.getNumber(20));//4181
    }
}

/**
 * 斐波那契规律
 *  第n项等于（n-1）项+(n-2)项
 */
class   Fibonacci{
    public static int getNumber(int n){
        if(n == 1){
            return 0;
        }else if(n == 2){
            return  1;
        }else{
            return getNumber(n - 1) + getNumber(n - 2);
        }
    }
}