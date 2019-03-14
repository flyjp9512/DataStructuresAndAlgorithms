package com.flyjp.dsaa;

/**
 * 遍历二叉树
 * 前序遍历：根节点->左子节点->右子节点
 * 中序遍历：左子节点->根节点->右子节点
 * 后序遍历：左子节点->右子节点->根节点
 *
 * 删除二叉树结点 三种情况：
 *  1.该节点是叶子节点，没有子节点
 *  要删除叶子节点，只需要改变该节点的父节点的引用值，将指向该节点的引用设置为null就可以了
 *  2.该节点有一个子节点。
 *  改变父节点的引用，将其直接指向要删除节点的子节点
 *  3.该节点有两个子节点
 *  要删除有两个子节点的节点，就需要使用它的中序后继来代替该节点
 *
 */


public class TestTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10,"A");
        tree.insert(20,"B");
        tree.insert(15,"C");
        tree.insert(3,"D");
        tree.insert(4,"E");
        tree.insert(90,"F");
//        System.out.println(tree.root.leftChild.data);//3
//
//        System.out.println(tree.find(3).str);//D
//        //前序遍历
//        tree.frontOrder(tree.root);//10 3 4 20 15 90
//        System.out.println("-----------");
//        //中序遍历
//        tree.inOrder(tree.root);//3 4 10 15 20 90
//        System.out.println("-----------");
//        //后序遍历
//        tree.afterOrder(tree.root);//4 3 15 90 20 10
        System.out.println("-----------");
        tree.delete(15);
        tree.inOrder(tree.root);

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
    public boolean delete(long value){
        //引用当前节点，从根节点开始
        TreeNode current = root;
        //应用当前节点的父节点
        TreeNode parent = root;
        //是否为左节点
        boolean isLeftChild = true;
        while(current.data != value) {
            parent = current;
            if (current.data > value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if(current == null){
                return  false;
            }
        }

                //删除叶子节点，也就是该节点没有子节点
                if(current.leftChild == null && current.rightChild == null){
                    //如果删除节点是根节点 为null
                    if(current == root){
                        root = null;
                    } else if(isLeftChild){//如果是父节点的左子节点
                        parent.leftChild = null;
                    }else{
                        parent.rightChild = null;
                    }
                    return true;
                    //只有一个子节点，改变父节点的引用，将其直接指向要删除节点的子节点
                }else if(current.rightChild == null){
                    if(current == root){
                        root = current.leftChild;
                    }else if(isLeftChild){
                        parent.leftChild = current.leftChild;
                    }else{
                        parent.rightChild = current.leftChild;
                    }
                    return true;
                }else if(current.leftChild == null){
                    if(current == root){
                        root = current.rightChild;
                    }else if(isLeftChild){
                        parent.leftChild = current.rightChild;
                    }else{
                        parent.rightChild = current.rightChild;
                    }
                }else{
                    //获得删除节点的中序后继节点的子树
                    TreeNode successor = getSuccessor(current);
                    if(current == root){
                        root = successor;
                    }else if(isLeftChild){
                        parent.leftChild = successor;//第三步：删除节点替换成中序后继子树
                    }else{
                        parent.rightChild = successor;//第三步：删除节点替换成中序后继子树
                    }
                    successor.leftChild = current.leftChild;//第四步：中序后继的做节点哟换成删除节点的左子树
                    return true;
                }


        return false;
    }


    /**
     * 中序后继节点 删除节点的下一个值
     */
    public TreeNode getSuccessor(TreeNode delNode){
        TreeNode successor = delNode;
        TreeNode successorParent = delNode;
        TreeNode current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != delNode.rightChild){
            //第一步：中序后继节点的位置替换成中序后继节点的右子树
            successorParent.leftChild = successor.rightChild;
            //第二步：中序后继节点的右子树替换成删除节点右子树
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * 前序遍历
     */
    public void frontOrder(TreeNode localNode){
        if(localNode != null){
            //访问根节点
            System.out.println(localNode.data + "," +localNode.str);
            //前序遍历左子树
            frontOrder(localNode.leftChild);
            //前序遍历右子树
            frontOrder(localNode.rightChild);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode localNode){
        if(localNode != null){

            //中序遍历左子树
            inOrder(localNode.leftChild);
            //访问根节点
            System.out.println(localNode.data + "," +localNode.str);
            //中序遍历右子树
            inOrder(localNode.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    public void afterOrder(TreeNode localNode){
        if(localNode != null){

            //后序遍历左子树
            afterOrder(localNode.leftChild);
            //后序遍历右子树
            afterOrder(localNode.rightChild);
            //访问根节点
            System.out.println(localNode.data + "," +localNode.str);
        }
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
