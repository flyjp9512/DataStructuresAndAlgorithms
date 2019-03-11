package com.flyjp.dsaa;

public class TestLinkList {

    public static void main(String[] args){
        LinkList linkList = new LinkList();
        linkList.insertFirst(34);
        linkList.insertFirst(23);
        linkList.insertFirst(12);

        linkList.display();//12 23 34

        linkList.deleteFirst();
        linkList.display();//23 34

        Node node = linkList.find(23);
        node.display();//23
        linkList.insertFirst(0);
        linkList.insertFirst(-1);
        Node node1 = linkList.delete(0);//node1.data = 0;
        linkList.display();//-1 23 34
    }
}

class LinkList{
    //头节点
    private Node first;

    public LinkList(){
        first = null;
    }
    /**
     * 插入一个结点，在头节点后进行插入
     */
    public void insertFirst(long value){
        Node node = new Node(value);
        node.next = first;//新指针域指向头指针域
        first = node ;//头节点替换新节点
    }

    /**
     * 删除一个结点，在头节点后进行删除
     */
    public Node deleteFirst(){
        Node tmp = first;
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

/**
 * 链节点
 */
class Node{
    //数据域
    public long data;
    //指针域
    public Node next;

    public Node(long value){
        this.data = value;
    }

    /**
     * 显示方法
     */
    public void display(){
        System.out.print(data + " ");
    }

}

