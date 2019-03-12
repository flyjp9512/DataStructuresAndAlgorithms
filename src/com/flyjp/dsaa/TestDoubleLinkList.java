package com.flyjp.dsaa;

/**
 * 双向链表
 * 每一个结点除了保存了对下一个节点的引用，同时还保存这对前一个结点的引用。
 */
public class TestDoubleLinkList {

    public static void main(String[] args){
        DoubleLinkList linkList = new DoubleLinkList();
        linkList.insertLast(45);
        linkList.insertLast(56);
        linkList.insertLast(90);
        linkList.display();//45 56 90

//        linkList.deleteLast();
//        linkList.display();//45 56

        while(!linkList.isEmpty()){
            linkList.deleteLast();
            linkList.display();
        }


    }
}

class DoubleLinkList {

    //头结点
    private Node first;
    //尾结点
    private Node last;

    public DoubleLinkList() {
        first = null;
    }


    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 插入一个结点，在头结点进行插入
     */
    public void insertFirst(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            last = node;//尾结点是新添加的结点
        } else {
            first.previous = node;
        }
        node.next = first;//新指针域指向头指针域
        first = node;//头结点替换新结点
    }

    /**
     * 插入一个结点，从尾结点插入
     */
    public void insertLast(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;//尾结点是新添加的结点
    }

    /**
     * 删除一个结点，在头结点后进行删除
     */
    public Node deleteFirst() {
        Node tmp = first;
        if (first.next == null) {//first是最后一个结点的
            last = null; //尾结点为空
        }else{
            first.next.previous = null;//头结点的前一个结点尾null
        }
        first = tmp.next;
        return tmp;
    }

    /**
     * 删除结点，从尾部进行删除
     */
    public Node deleteLast(){
        Node tmp = last;
        if(first.next == null){
            first = null;
            last = null;
        }else{
            last.previous.next = null;
            last = last.previous;
        }
        return tmp;
    }

    /**
     * 显示方法
     */
    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * 查找方法
     */
    public Node find(long value) {
        Node current = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 删除方法，根据数据域来进行删除
     */
    public Node delete(long value) {
        Node current = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        if (current == first) {
            first = first.next;
            last = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        return current;
    }

}
