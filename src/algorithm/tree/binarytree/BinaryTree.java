package algorithm.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public Node root = null;

    public BinaryTree() {
    }

    public BinaryTree(Node node) {
        root = node;
    }

    public void preOrderTraverse(){
        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();
    }

    //================前序遍历======================

    private void preOrderTraverse(Node root){
        if(root==null)
            return;
        root.displayNode();
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);

    }

    public void preOrderTraverseByStack(){
        System.out.println("先序遍历：");
        preOrderTraverseByStack(root);
        System.out.println();
    }

    private void preOrderTraverseByStack(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);//首先将根结点入栈
        Node current = root;
        while (!s.empty()) {
            current = s.pop();
            if (current != null) {
                current.displayNode();
                //由于栈的FILO原则，先序遍历需要先左子树后右子树，所以这里需要将右子树先入栈
                s.push(current.rightChild);
                s.push(current.leftChild);
            }
        }
    }

    //================中序遍历======================

    public void inOrderTraverse(){
        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();
    }
    private void inOrderTraverse(Node root){
        if(root==null)
            return;
        inOrderTraverse(root.leftChild);
        root.displayNode();
        inOrderTraverse(root.rightChild);
    }

    public void inOrderTraverseByStack(){
        System.out.println("中序遍历：");
        inOrderTraverseByStack(root);
        System.out.println();
    }
    private void inOrderTraverseByStack(Node root){
        Stack<Node> s = new Stack<>();
        Node current = root;
        while(current!=null||!s.isEmpty()){
            //将左子树放入栈
            while(current!=null){
                s.push(current);
                current = current.leftChild;
            }
            current = s.pop();
            current.displayNode();//访问根结点
            current = current.rightChild;//遍历右子树，将右子树入栈
        }
    }

    //================后序遍历======================

    public void postOrderTraverse(){
        System.out.println("后序遍历：");
        postOrderTraverse(root);
        System.out.println();
    }
    private void postOrderTraverse(Node root){
        if(root==null)
            return;
        postOrderTraverse(root.leftChild);//后序遍历左子树
        postOrderTraverse(root.rightChild);//后序遍历右子树
        root.displayNode();//最后访问根结点
    }

    public void postOrderTraverseByStack(){
        System.out.println("后序遍历：");
        postOrderTraverseByStack(root);
        System.out.println();
    }
    private void postOrderTraverseByStack(Node root){
        Stack<Node> s = new Stack<>();
        Node curr = root;
        Node last = null;//前一个已经访问的节点
        while(curr != null || !s.empty()){ // 栈空时结束
            while(curr != null){// 一直向左走直到为空
                s.push(curr);
                curr = curr.leftChild;
            }
            curr = s.peek();
            // 当前节点的右孩子如果为空或者已经被访问，则访问当前节点
            if(curr.rightChild == null || curr.rightChild == last){
                curr.displayNode();
                last = curr;
                s.pop();
                curr = null;
            }
            else
                curr = curr.rightChild;// 否则访问右孩子
        }
    }

    //================层序遍历======================

    public void levelOrderTraverse(){
        System.out.println("层序遍历：");
        levelOrderTraverse(root);
        System.out.println();
    }
    private void levelOrderTraverse(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        Node curr = root;
        while(curr!=null||!queue.isEmpty()){
            while(curr!=null){
                if(queue.isEmpty())//第一次需要放入根结点
                    queue.add(curr);
                if(curr.leftChild!=null)
                    queue.add(curr.leftChild);
                if(curr.rightChild!=null)
                    queue.add(curr.rightChild);
                curr=null;
            }
            curr = queue.poll();
            curr.displayNode();
            curr = queue.peek();
        }
    }

    /**
     * 判断树是否为空
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 获取树的深度
     */
    public int getDeepth(){
        return getDeepth(root);
    }
    private int getDeepth(Node root){
        if(root==null)
            return 0;
        int left = getDeepth(root.leftChild);
        int right = getDeepth(root.rightChild);
        return left >= right ? left + 1 : right + 1;//左右子树深度较大值+1
    }

    /**
     * 结点数目
     */
    public int size(){
        return this.size(root);
    }

    private int size(Node root){
        if(root==null)
            return 0;
        int nl = size(root.leftChild);
        int nr = size(root.rightChild);
        return nl + nr + 1;//树的总结点数为左子树结点数+右子树结点数+1(根结点)
    }

    /**
     * 获取叶子结点数
     */
    public int numberOfLeafs(){
        return this.numberOfLeafs(root);
    }
    private int numberOfLeafs(Node root){
        if(root==null)
            return 0;//结点为null直接返回0
        if(root.leftChild==null&&root.rightChild==null)
            return 1;//如果结点没有左右结点，那么该结点就是叶子结点，返回1
        return numberOfLeafs(root.leftChild)+numberOfLeafs(root.rightChild);//该节点不是叶子结点，计算它的左右子树的叶子结点之和
    }

    /**
     * 计算满结点(度为2)的个数
     */
    public int numberOfFulls(){
        return this.numberOfFulls(root);
    }
    private int numberOfFulls(Node root){
        if(root==null)
            return 0;
        else if(root.leftChild==null&&root.rightChild==null)
            return 0;//叶子结点，不是满结点，直接返回0
        else if(root.leftChild!=null&&root.rightChild==null)
            return  numberOfFulls(root.leftChild);//左孩子不为空，右孩子为空，满结点可以存在左子树中
        else if(root.leftChild==null&&root.rightChild!=null)
            return numberOfFulls(root.rightChild);//左孩子为空，右孩子不为空，满结点可以存在右子树中
        else
            return 1+numberOfFulls(root.leftChild)+numberOfFulls(root.rightChild);//左右孩子都不为空，当前结点是满结点，并且它的左右子树中都可能存在满结点
    }

//    根据二叉树性质3，代码也可以写为：
//    public int numberOfFulls(){
//        return this.numberOfLeafs(root)-1;
//    }

    /**
     * 查找指定值的结点
     */
    public Node findValue(String value){
        return findValue(root,value);
    }
    private Node findValue(Node node,String value){
        if(node==null)
            return null;
        else if(node.data.equals(value))
            return node;
        else{
            Node nodeL = this.findValue(node.leftChild,value);//未找到则从左子树查找
            Node nodeR = this.findValue(node.rightChild,value);//从右子树查找
            if(nodeL!=null&&node.data.equals(value))
                return nodeL;
            else if(nodeR!=null&&nodeR.data.equals(value))
                return nodeR;
            else
                return null;
        }
    }

    //================二叉树镜像=====================

    /**
     * 递归获取镜像
     */
    public void getMirror(){
        this.getMirror(root);
    }

    private void getMirror(Node node){
        if(node==null)
            return;
        //交换左右孩子
        Node temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;
        if(node.leftChild!=null)//以左孩子为根，翻转左子树
            getMirror(node.leftChild);
        if(node.rightChild!=null)
            getMirror(node.rightChild);
    }

    /**
     * 非递归获取镜像
     */
    public void getMirrorByStack(){
        this.getMirrorByStack(root);
    }
    private void getMirrorByStack(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node top = stack.pop();
            Node temp = top.leftChild;
            top.leftChild = top.rightChild;
            top.rightChild = temp;
            if(top.leftChild!=null)
                stack.push(top.leftChild);
            if(top.rightChild!=null)
                stack.push(top.rightChild);
        }
    }
}
