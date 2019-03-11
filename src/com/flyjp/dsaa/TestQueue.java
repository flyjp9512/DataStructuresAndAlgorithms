package com.flyjp.dsaa;

/**
 * 队列 先进先出 后进后出
 */
public class TestQueue {

    public static void main(String[] args){
        MyQueue myQueue = new MyQueue(4);
        myQueue.insert(23);
        myQueue.insert(45);
        myQueue.insert(13);
        myQueue.insert(1);

        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());

        System.out.println(myQueue.peek());

        while(!myQueue.isEmpty()){
            System.out.print(myQueue.remove()+",");
        }

        System.out.println("\n----------");

        myQueue.insert(23);
        myQueue.insert(45);
        myQueue.insert(13);
        myQueue.insert(1);

        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());

        System.out.println(myQueue.peek());

        while(!myQueue.isEmpty()){
            System.out.print(myQueue.remove()+",");
        }
    }

}

class MyQueue{
    //底层使用数组
    private  long[] arr;
    //有效数据的大小
    private  int elements;
    //队头
    private int front;
    //队尾
    private int end;

    public MyQueue(){
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    public MyQueue(int maxSize){
        arr = new long[maxSize];
        elements = 0;
        front = 0;
        end = -1;
    }

    /**
     * 添加,从队尾插入
     */
    public void insert(long value){
        if(end == arr.length -1){
            end = -1;
        }
        arr[++end] = value;
        elements++;
    }

    /**
     * 删除，从队头删除
     */
    public long remove(){
        long value = arr[front++];
        if(front == arr.length){
            front = 0;
        }
        elements--;
        return value;
    }

    /**
     * 查看，从队头查看
     */
    public long peek(){
        return arr[front];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return elements == 0;
    }

    /**
     * 判断是否满了
     */
    public boolean isFull(){
        return elements == arr.length;
    }
}
