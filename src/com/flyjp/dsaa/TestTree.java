package com.flyjp.dsaa;

public class TestTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10,"A");
        tree.insert(20,"B");
        tree.insert(15,"C");
        tree.insert(3,"D");
        System.out.println(tree.root.leftChild.data);//3

        System.out.println(tree.find(3).str);//D
    }
}

/**
 * 树
 */
class Tree{

    //根节点
    public  TreeNode root;

    /**
     * 插入节点
     */
    public void insert(long value,String str){
        //封装节点
        TreeNode node = new TreeNode(value,str);
        //引用当前节点
        TreeNode current = root;
        //引用父节点
        TreeNode parent;
        if(root == null){
           root = node;
           return;
        }else{
            while(true) {
                //父节点指向当前节点
                parent = current;
                //如果当前指向的节点数据比插入的要大，则向左走
                if (current.data > value) {
//                    current = current.leftChild;
//                    if(current == null){//没有子节点
//                        parent.leftChild = node;
//                        return;
//                    }
                    if(current.leftChild == null){
                        current.leftChild = node;
                        return;
                    }else{
                        current = current.leftChild;
                    }
                } else {
                    current = current.rightChild;
                    if(current == null){//没有子节点
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }

    /**
     * 查找节点
     */
    public TreeNode find(long value){
        //引用当前节点，从根节点开始
        TreeNode current = root;
        //循环，只要查找的值不等于当前节点的数据项
        while(current.data != value){
            //进行比较，比较查找值和当前节点的大小
            if(current.data > value){
                current = current.leftChild;//向下查找左子节点
            }else{
                current = current.rightChild;//向下查找右子节点
            }
            if(current == null){
                return null;
            }
        }
        return current;

    }

    /**
     * 删除节点
     */
    public void delete(long value){

    }

}

/**
 * 节点
 */
class TreeNode{
    //数据项
    public  long data;//索引

    public String str;//内容
    //左子节点
    public  TreeNode leftChild;
    //右子节点
    public  TreeNode rightChild;

    public TreeNode(long data,String str){
        this.data = data;
        this.str = str;
    }
}
