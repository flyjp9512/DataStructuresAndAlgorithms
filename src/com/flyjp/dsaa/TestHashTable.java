package com.flyjp.dsaa;

import java.math.BigInteger;

/**
 * 哈希表
 * 开放地址法 在表中开放一个null的地址 缺陷;会占用别人的位置
 * 链地址法
 */
public class TestHashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(new Info("a","张三"));
        hashTable.insert(new Info("ct","李四"));
        hashTable.insert(new Info("b","王五"));

        System.out.println(hashTable.find("a").getName());
        System.out.println(hashTable.find("ct").getName());//李四
        System.out.println(hashTable.find("b").getName());//李四
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
     * 插入数据  开放地址法
     */
    public void insert(Info info){
        //获得关键字
        String key = info.getKey();
        //关键字所定义的哈希数
        int hashVal = hashCode(key);
        //如果这个索引已经被占用，而且里面是一个未被删除的数据
        while(arr[hashVal] != null && arr[hashVal].getName() != null){
            //进行递增
            ++hashVal;
            hashVal %= arr.length;
        }
        arr[hashVal] = info;
    }



    /**
     * 查找数据 开放地址法
     */
    public Info find(String key){
        int hashVal = hashCode(key);
        //不为空
        while(arr[hashVal] != null){
            if(arr[hashVal].getKey().equals(key)){
                return arr[hashVal];
            }
            ++hashVal;
            hashVal &= arr.length;
        }
        return null;
    }

    /**
     * 删除数据 开放地址法
     */
    public Info delete(String key){
        int hashVal = hashCode(key);
        while(arr[hashVal] != null){
            if(arr[hashVal].getKey().equals(key)){
                Info tmp = arr[hashVal];
                tmp.setName(null);
                return tmp;
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
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



