package algorithm.linkedList;

/**
 * 链表
 * @author wangzhiguo
 */
public class LinkedList {

    /**
     * 206，141，21，19，876
     * 单链表反转
     * 链表中环的检测
     * 两个有序的链表合并
     * 删除链表倒数第n个结点
     * 求链表的中间结点
     */

    public static void main(String[] args) {
        Node head = new Node();
        head.setVal(1);

        Node node1 = new Node();
        node1.setVal(2);
        head.setNext(node1);

        Node node2 = new Node();
        node2.setVal(3);
        node1.setNext(node2);

        Node node3 = new Node();
        node3.setVal(4);
        node2.setNext(node3);

        Node node4 = new Node();
        node4.setVal(5);
        node3.setNext(node4);
        Node node = reverseList2(head);
        printElementByRecursive(node);
    }

    /**
     * 1，2，3，4，5反转
     */
    public static Node reverseList1(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    /**
     * 递归反转单向链表
     */
    public static Node reverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 通过循环
     * 打印链表中每一个元素
     */
    public static Node printElementByWhile(Node head) {
        while (head !=null) {
            System.out.println(head.val);
            head = head.next;
        }

        return null;
    }

    /**
     * 通过递归
     * 打印链表中每一个元素
     */
    public static Node printElementByRecursive(Node head) {
        if (head == null) {
            return null;
        }

        System.out.println(head.val);

        if (head.next == null) {
            return null;
        }

        Node node = printElementByRecursive(head.next);

        return null;
    }

    static class Node{

        int val;

        Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
