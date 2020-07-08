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
        ListNode head = new ListNode();
        head.setVal(1);

        ListNode listNode1 = new ListNode();
        listNode1.setVal(2);
        head.setNext(listNode1);

        ListNode listNode2 = new ListNode();
        listNode2.setVal(3);
        listNode1.setNext(listNode2);

        ListNode listNode3 = new ListNode();
        listNode3.setVal(4);
        listNode2.setNext(listNode3);

        ListNode listNode4 = new ListNode();
        listNode4.setVal(5);
        listNode3.setNext(listNode4);
        ListNode listNode = removeNthFromEnd(head, 2);
        printElementByRecursive(listNode);
    }

    /**
     * 1，2，3，4，5反转
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    /**
     * 递归反转单向链表
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 获取中间节点
     */
    public static ListNode getMidNode1(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int i = 0;
        while (head != null) {
            arr[i] = head;
            head = head.next;
            i++;
        }
        return arr[i / 2];
    }

    /**
     * 获取中间节点
     */
    public static ListNode getMidNode2(ListNode head) {
        ListNode temp = head;
        int i = 0;
        int j = 0;
        while (head != null) {
            head = head.next;
            i++;
        }

        while (temp != null) {
            if (j == i / 2) {
                return temp;
            }
            temp = temp.next;
            j++;
        }

        return null;
    }

    /**
     * 快慢指针
     * 获取中间节点
     */
    public static ListNode getMidNode3(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 删除倒数第N个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //定义头结点
        ListNode dummy = new ListNode(0);
        //连接在链表上
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        //长度为5，删除倒数第2个元素，结果为3
        //要删除的元素为第4个
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 合并两个有序列表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }

        l1.next = l2;



        return null;
    }

    /**
     * 通过循环
     * 打印链表中每一个元素
     */
    public static ListNode printElementByWhile(ListNode head) {
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
    public static ListNode printElementByRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        System.out.println(head.val);

        if (head.next == null) {
            return null;
        }

        ListNode listNode = printElementByRecursive(head.next);

        return null;
    }

    static class ListNode {

        int val;

        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


}
