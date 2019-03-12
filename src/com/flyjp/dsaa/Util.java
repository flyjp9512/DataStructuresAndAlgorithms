package com.flyjp.dsaa;

public class Util {

    public static String print(long[] arr){
        String str = "{";
        for(long i:arr){
            str += (i+",");
        }
        str = str.substring(0,str.length()-1);
        str += "}";
        return str;
    }
}
