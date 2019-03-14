package com.flyjp.dsaa;

import java.math.BigInteger;

/**
 * 哈希表
 */
public class TestHashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(new Info("abc","张三"));
        hashTable.insert(new Info("cba","李四"));
        hashTable.insert(new Info("bbb","王五"));

        System.out.println(hashTable.find("abc").getName());
        System.out.println(hashTable.find("cba").getName());//李四
        System.out.println(hashTable.find("bbb").getName());//李四
    }
}

class HashTable{

    private Info[] arr;
    /**
     * 默认构造
     */
    public HashTable(){
        arr = new Info[10000];
    }

    /**
     * 指定数组初始化大小
     */
    public HashTable(int maxSize){
        arr = new Info[maxSize];
    }

    /**
     * 插入数据
     */
    public void insert(Info info){
        arr[hashCode(info.getKey())] = info;
    }

    /**
     * 查找数据
     */
    public Info find(String key){
        return arr[hashCode(key)];
    }

    /**
     * 哈希化
     * 1）直接将关键字作为索引
     * 2）将单词转换成索引
     *  将字母传换成ASCII码，然后追加
     *  幂的连乘
     *  压缩可选值
     * @param key
     * @return
     */
    public int hashCode(String key){
//        int hashVal = 0;
//        for(int i = key.length() - 1 ; i >= 0 ; i--){
//            int letter = key.charAt(i) - 96;
//            hashVal += letter;
//        }
//        return  hashVal;
        BigInteger hashVal = new BigInteger("0");
        BigInteger  pow27 = new BigInteger("1");
        for(int i= key.length()  -1 ; i >= 0 ; i--){
            BigInteger letter = new BigInteger(String.valueOf(key.charAt(i) -96)) ;
            hashVal = hashVal.add(letter.multiply(pow27)) ;
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
                //压缩后仍然能出现问题
        return  hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue() ;

    }
}


/**
 * 员工信息
 */
class Info{
    private  String key;
    private  String name;

    public Info(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public Info() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
