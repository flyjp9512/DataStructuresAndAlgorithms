package com.flyjp.dsaa;

/**
 * 双端链表
 */
public class TestFirstLastLinkList {

    public static void main(String[] args){
        FirstLastLinkList linkList = new FirstLastLinkList();
//        linkList.insertFirst(34);
//        linkList.insertFirst(23);
//        linkList.insertFirst(12);
//
//        linkList.display();//12 23 34
//
//        linkList.deleteFirst();
//        linkList.deleteFirst();
//        linkList.display();// 34

        linkList.insertLast(56);
        linkList.insertLast(90);
        linkList.insertLast(12);
        linkList.display();//56 90 12

        linkList.deleteFirst();
        linkList.display();//90 12



    }
}

class FirstLastLinkList{

    //头结点
    private Node first;
    //尾结点
    private Node last;

    public FirstLastLinkList(){
        first = null;
    }


    /**
     * 判断是否为空
     *
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * 插入一个结点，在头结点进行插入
     */
    public void insertFirst(long value){
        Node node = new Node(value);
        if(isEmpty()){
            last = node;//尾结点是新添加的结点
        }
        node.next = first;//新指针域指向头指针域
        first = node ;//头结点替换新结点
    }

    /**
     * 插入一个结点，从尾结点插入
     */
    public void insertLast(long value){
        Node node = new Node(value);
        if(isEmpty()){
            first = node;
        }else{
            last.next = node;
        }
        last = node;//尾结点是新添加的结点
    }

    /**
     * 删除一个结点，在头结点后进行删除
     */
    public Node deleteFirst(){
        Node tmp = first;
        if(first.next == null){//first是最后一个结点的
            last = null; //尾结点为空
        }
        first = tmp.next;
        return  tmp;
    }

    /**
     * 显示方法
     */
    public void display(){
        Node current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * 查找方法
     */
    public Node find(long value){
        Node current = first;
        while(current.data != value){
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
    public Node delete(long value){
        Node current = first;
        Node previous = first;
        while(current.data != value){
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
