package net.tanpeng.arithmetic.offers;

/**
 * 剑指Offer，第56题：链表中环的入口结点
 * <p>
 * 题目描述：
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * <p>
 * 考点：链表的简单操作
 * 首先通过一快一慢两个指针找到是否有环，而且确定环中的任意一点的位置
 * 通过那个位置找出环的大小，然后两个指针同时从起点出发，一个先走环的长度。
 *
 * 这样p1就是比p2多了刚好一圈，那p1第一次转完一圈之后，p2刚好把这个距离给补上了，那个点就是圈的起点。
 *
 * 通过大小，再弄两个指针找出环的起点
 *
 * @author: peng.tan
 * @create: 2020/08/09 17:21
 */
public class EntryNodeOfLoop {

    private ListNode findMeet(ListNode pHead) {
        ListNode low = pHead;
        ListNode fast = pHead.next;

        while (low != null && fast != null) {
            if (low == fast) {
                return fast;
            }
            low = low.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        // 先找到相遇的那个点
        ListNode meetNode = findMeet(pHead);
        ListNode tempNode = meetNode;
        if (meetNode == null) {
            return null;
        }
        // 找到起点到交汇点的距离
        int distance = 1;
        while (tempNode.next != meetNode) {
            tempNode = tempNode.next;
            distance++;
        }
        // 让一个指针先走一圈，这样两个指针，一个从头，一个从一圈后那里出发。一定会在环的起点相遇。
        for (int i = 0; i < distance; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}