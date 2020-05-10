package net.tanpeng.arithmetic.offers;

import java.util.List;

/**
 * @author: peng.tan
 * @create: 2020/05/04 19:39
 */

public class FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail2(ListNode head, int k) {
        // 反转链表，就当练手好了
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 当前的下一个指向前一个，要暂存 cur.next，因为cur.next下一次会被覆盖掉
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 结果是pre
        for (int i = 1; i < k; i++) {
            if (pre == null) {
                return null;
            }
            pre = pre.next;
        }
        return new ListNode(pre.val);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        int index = 0;
        for (; p != null; index++) {
            // 倒数第k个，那大于k的时候，才开始往后面遍历即可
            if (index > k) {
                q = q.next;
            }
            p = p.next;
        }
        return index < k ? null : q;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode result = fanzhuan(listNode);
        System.out.println();
    }

    public static ListNode fanzhuan(ListNode listNode) {
        ListNode pre = null;
        ListNode cur = listNode;
        // 最关键的在于cur.next -> pre
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
