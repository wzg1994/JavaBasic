package leetcode.demo002;

public class addTwoNumbers {

    public static void main(String[] args) {

        /*
          给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。

          如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

          您可以假设除了数字 0 之外，这两个数都不会以 0开头。

          示例：

          输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
          输出：7 -> 0 -> 8
          原因：342 + 465 = 807

          来源：力扣（LeetCode）
          链接：https://leetcode-cn.com/problems/add-two-numbers
          著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1.next = l1_1;
        l1_1.next = l1_2;


        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(7);
        l2.next = l2_1;
        l2_1.next = l2_2;

        ListNode solution = solution(l1, l2);

        showList(l1);
    }

    static ListNode solution(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            int i = l1.val + l2.val;
            int mole = i % 10;


        }

        return null;
    }

    static void showList(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }


}
