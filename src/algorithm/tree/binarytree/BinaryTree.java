package algorithm.tree.binarytree;

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

}
