package net.tanpeng.arithmetic.offers;

import org.omg.CORBA.IRObject;

/**
 * @author: peng.tan
 * @create: 2020/08/09 17:55
 */
public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = pHead;
        ListNode result = null;
        ListNode result2 = null;
        pHead = pHead.next;
        if (pHead == null) {
            return pre;
        }
        if (pre.val != pHead.val) {
            result = new ListNode(pre.val);
            result2 = result;
        }
        while (pHead.next != null) {
            if (pHead.val == pHead.next.val || pHead.val == pre.val) {
//                continue;
            } else {
                if (result == null) {
                    result = new ListNode(pHead.val);
                    result2 = result;
                } else {
                    result.next = new ListNode(pHead.val);
                }
                result = result.next == null ? result : result.next;
            }
            pre = pHead;
            pHead = pHead.next;
        }

        if (pHead.val != pre.val) {
            if (result == null) {
                result = new ListNode(pHead.val);
                result2 = result;
            } else {
                result.next = new ListNode(pHead.val);
            }
        }
        return result2;
    }

    public static void main(String[] args) {
        ListNode li = new ListNode(1);
        ListNode head = li;
//        li.next = new ListNode(1);
//        li = li.next;
//        li.next = new ListNode(2);
//        li = li.next;
//        li.next = new ListNode(3);
//        li = li.next;
//        li.next = new ListNode(3);
//        li = li.next;
//        li.next = new ListNode(4);
//        li = li.next;
//        li.next = new ListNode(5);
//        li = li.next;
//        li.next = new ListNode(5);
        ListNode result = deleteDuplication(head);
        System.out.println();
    }
}
