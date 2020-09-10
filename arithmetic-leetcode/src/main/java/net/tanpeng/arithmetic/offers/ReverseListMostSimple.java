package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/08/26 22:29
 */
public class ReverseListMostSimple {

    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        // 1->2->3->4
        // 4->3->2->1
        ListNode li = new ListNode(1);
        ListNode head = li;
        li.next = new ListNode(2);
        li = li.next;
        li.next = new ListNode(3);
        li = li.next;
        li.next = new ListNode(4);
        li = li.next;
        ReverseList(head);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
