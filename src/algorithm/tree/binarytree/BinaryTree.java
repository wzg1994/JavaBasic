package algorithm.tree.binarytree;

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

}
