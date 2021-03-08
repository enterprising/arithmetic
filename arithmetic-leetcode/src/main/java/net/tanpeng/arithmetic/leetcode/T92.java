package net.tanpeng.arithmetic.leetcode;

import net.tanpeng.arithmetic.offers.ListNode;

import java.util.List;

/**
 * 反转特定部分的反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author: peng.tan
 * @create: 2021/03/08 10:32
 */
public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int index = 1;
        ListNode midList = null;
        ListNode preCut = head;
        ListNode afterCut;
        ListNode afterCutRes = null;
        while (head != null) {
            if (index >= left && index <= right) {
                ListNode temp = head.next;
                head.next = midList;
                midList = head;
                head = temp;
            } else {
                if (index > right) {
                    afterCut = head;
                    if (afterCutRes == null) {
                        afterCutRes = afterCut;
                    }
                    afterCut = afterCut.next;
                }
                head = head.next;
            }
            index++;
        }
        // 组装
        ListNode preRes = preCut;
        while (preCut != null) {
            if (preCut.next == null) {
                preCut = null;
                preRes = null;
                break;
            }
            if (preCut.next.next == null) {
                preCut.next = null;
                break;
            }
            preCut = preCut.next;
        }

        ListNode result = new ListNode(-1);
        ListNode result2 = result;
        result.next = preRes;
        while (result.next != null) {
            result = result.next;
        }
        result.next = midList;
        while (result.next != null) {
            result = result.next;
        }
        result.next = afterCutRes;
        return result2.next;
    }

    public static void main(String[] args) {
        ListNode ListNode = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);

        ListNode.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = ListNode5;

//        ListNode ListNode = new ListNode(3);
//        ListNode ListNode2 = new ListNode(5);
//        ListNode.next = ListNode2;
        new T92().reverseBetween(ListNode, 2, 4);
    }
}
