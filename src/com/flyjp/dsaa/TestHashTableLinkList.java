package com.flyjp.dsaa;

import java.math.BigInteger;

/**
 * 哈希表
 * 链地址法
 */
public class TestHashTableLinkList {

    public static void main(String[] args) {
        HashTableLinkList hashTable = new HashTableLinkList();
        hashTable.insert(new Info("a","张三"));
        hashTable.insert(new Info("ct","李四"));
        hashTable.insert(new Info("b","王五"));

        System.out.println(hashTable.find("a").getName());//张三
        System.out.println(hashTable.find("ct").getName());//李四
        hashTable.delete("b");
        System.out.println(hashTable.find("b").getName());//null


    }
}

class HashTableLinkList{

     private LinkList[] arr;

    /**
     * 默认构造
     */
    public HashTableLinkList(){
        arr = new LinkList[100];
    }

    /**
     * 指定数组初始化大小
     */
    public HashTableLinkList(int maxSize){
        arr = new LinkList[maxSize];
    }

    /**
     * 插入数据  链地址法
     */
    public void insert(Info info){
        //获得关键字
        String key = info.getKey();
        //关键字所定义的哈希数
        int hashVal = hashCode(key);
        if(arr[hashVal] == null){
            arr[hashVal] = new LinkList();
        }
        arr[hashVal].insertFirst(info);
    }



    /**
     * 查找数据 链地址法
     */
    public Info find(String key){
        int hashVal = hashCode(key);
        return  arr[hashVal].find(key).info;
    }

    /**
     * 删除数据 链地址法
     */
    public Info delete(String key){
        int hashVal = hashCode(key);
      return  arr[hashVal].delete(key).info;
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

class LinkList{
    //头结点
    private Node first;

    public LinkList(){
        first = null;
    }
    /**
     * 插入一个结点，在头结点插入
     */
    public void insertFirst(Info value){
        Node node = new Node(value);
        node.next = first;//新指针域指向头指针域
        first = node ;//头结点替换新结点
    }

    /**
     * 删除一个结点，在头结点后进行删除
     */
    public Node deleteFirst(){
        Node tmp = first;
        first = tmp.next;
        return  tmp;
    }


    /**
     * 查找方法
     */
    public Node find(String key){
        Node current = first;
        while(!key.equals(current.info.getKey())){//key不会为null
            if(current.next == null){
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 删除方法，根据数据域来进行删除
     */
    public Node delete(String key){
        Node current = first;
        Node previous = first;
        while(!key.equals(current.info.getKey())){//key不会为null
                if(current.next == null){
                    return null;
                }
                previous = current;
                current = current.next;
        }
        if(current == first){
            first = first.next;
        }else{
            previous.next = current.next;
        }
        return current;
    }
}


/**
 * 链节点
 */
class Node{
    //数据域
    public Info info;
    //指针域
    public Node next;
    //前指针域
    public Node previous;

    public Node(Info info){
        this.info = info;
    }

}
