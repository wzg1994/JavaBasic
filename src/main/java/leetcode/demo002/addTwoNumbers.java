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
        ListNode l2_2 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_2;

        ListNode solution = solution(l1, l2);
        showList(solution);
    }

    /**
     * 要考虑到每一位数字上最大的权 9 + 9 + 1 = 18
     * 其中两个9代表两个链表的最大值，1则代表低位进位
     */
    static ListNode solution(ListNode l1, ListNode l2) {
        //使用了哑结点 简化了链表长度不一致为空等情况
        //curr = dummyHead很奇妙！！！
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static void showList(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }


}
