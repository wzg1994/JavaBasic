package algorithm.tree.binarytree;

public class test {

    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        Node node9 = new Node("I");
        //由于我们现在的这棵树没有规律，所以手动创建
        node1.leftChild = node2;
        node2.parentNode = node1;
        node1.rightChild = node3;
        node3.parentNode = node1;
        node2.leftChild = node4;
        node4.parentNode = node2;
        node4.leftChild = node7;
        node7.parentNode = node4;
        node4.rightChild = node8;
        node8.parentNode = node4;
        node3.leftChild = node5;
        node5.parentNode = node3;
        node3.rightChild = node6;
        node6.parentNode = node3;
        node5.rightChild = node9;
        node9.parentNode = node5;

        BinaryTree tree = new BinaryTree(node1);
//        tree.preOrderTraverse();
        tree.preOrderTraverseByStack();
    }
}
