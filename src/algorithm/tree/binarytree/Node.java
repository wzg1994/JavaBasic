package algorithm.tree.binarytree;

public class Node {

    public Node leftChild;//左孩子

    public Node rightChild;//右孩子

    public Node parentNode;//为了便于删除，我们也保存父节点的引用

    public String data;//数据域

    public Node(String i){
        this.data = i;
    }

    public void displayNode(){
        System.out.print(data+" ");
    }
}
