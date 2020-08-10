package net.tanpeng.arithmetic.offers;

/**
 * 两个链表逆序，相加。主要考虑进位，考虑链表的操作
 * Created by peng.tan on 2020/1/27.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int sub = 0;
        while (l1 != null || l2 != null || sub != 0) {
            int item1 = l1 == null ? 0 : l1.val;
            int item2 = l2 == null ? 0 : l2.val;
            int item = item1 + item2 + sub;
            if (item >= 10) {
                item = item % 10;
                sub = 1;
            } else {
                sub = 0;
            }
            result.next = new ListNode(item);
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l111 = new ListNode(3);
        ListNode l11 = new ListNode(4);
        ListNode l1 = new ListNode(2);
        l11.next = l111;
        l1.next = l11;
        ListNode l222 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l22.next = l222;
        l2.next = l22;
        System.out.println();

        System.out.println(addTwoNumbers(l1, l2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
