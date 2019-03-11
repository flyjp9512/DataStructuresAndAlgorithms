package com.flyjp.dsaa;

/**
 * 栈 先进后出 后进先出
 */
public class TestStack {
    public static void main(String[] args){
        MyStack myStack = new MyStack(4);
        myStack.push(23);
        myStack.push(12);
        myStack.push(1);
        myStack.push(90);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());

        System.out.println(myStack.peek());

        while(!myStack.isEmpty()){
            System.out.print(myStack.pop()+",");
        }

    }
}


class MyStack{
    private long[] arr;
    private int top;

    public MyStack(){
        arr = new long[10];
        top = -1;
    }

    public MyStack(int maxSize){
        arr = new long[maxSize];
        top = -1;
    }

    /**
     * 添加
     * @param value
     */
    public void push(int value){
        arr[++top] = value;
    }

    /**
     * 移除
     * @return
     */
    public long pop(){
        return arr[top--];
    }

    /**
     * 查看
     */
    public long peek(){
        return arr[top];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 判断是否满了
     */
    public boolean isFull(){
        return top == arr.length - 1;
    }

}
