package net.tanpeng.arithmetic.offers;

/**
 * 因为尾部相同，因此先找到长的链表，然后找到长度差。
 * 让长的先把长度差走完，然后再一起走，这样遇到的时候就是那个点了。
 *
 * @author: peng.tan
 * @create: 2020/08/09 22:22
 */
public class FindFirstCommonNode {

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = findLength(pHead1);
        int length2 = findLength(pHead2);
        int gap = Math.abs(length1 - length2);
        boolean isOneBigTwo = length1 > length2;
        for (int i = 0; i < gap; i++) {
            if (isOneBigTwo) {
                pHead1 = pHead1.next;
            } else {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;
    }

    private static int findLength(ListNode pHead1) {
        ListNode temp = pHead1;
        int instance = 0;
        while (temp.next != null) {
            instance++;
            temp = temp.next;
        }
        return instance;
    }


}
