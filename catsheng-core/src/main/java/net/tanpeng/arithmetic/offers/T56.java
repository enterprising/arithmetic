package net.tanpeng.arithmetic.offers;

/**
 * 剑指Offer，第56题：链表中环的入口结点
 * <p>
 * 题目描述：
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * <p>
 * 考点：链表的简单操作
 * 首先通过一快一慢两个指针找到是否有环，而且确定环中的任意一点的位置
 * 通过那个位置找出环的大小
 * 通过大小，再弄两个指针找出环的起点
 */
public class T56 {

    public ListNode fastLowList(ListNode pHead) {
        ListNode low, fast;
        low = pHead.next;
        if (low == null) {
            return null;
        }
        fast = low.next;

        while (fast != null && low != null) {
            if (fast == low) {
                return fast;
            }
            low = low.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode p1, p2;
        p1 = pHead;
        p2 = pHead;

        ListNode point = fastLowList(pHead);
        ListNode pointTemp = point;
        if (point == null)
            return null;

        int loopLength = 1;
        while (point.next != pointTemp) {
            point = point.next;
            loopLength++;
        }

        for (int i = 0; i < loopLength; i++) {
            p1 = p1.next;
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
