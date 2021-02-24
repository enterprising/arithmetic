package net.tanpeng.arithmetic.offers;

/**
 * 两个链表逆序，相加。主要考虑进位，考虑链表的操作
 * Created by peng.tan on 2020/1/27.
 */
public class AddTwoNumbers {
    public static ListNodeCur addTwoNumbers(ListNodeCur l1, ListNodeCur l2) {
        ListNodeCur result = new ListNodeCur(0);
        ListNodeCur head = result;
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
            result.next = new ListNodeCur(item);
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
        ListNodeCur l111 = new ListNodeCur(3);
        ListNodeCur l11 = new ListNodeCur(4);
        ListNodeCur l1 = new ListNodeCur(2);
        l11.next = l111;
        l1.next = l11;
        ListNodeCur l222 = new ListNodeCur(4);
        ListNodeCur l22 = new ListNodeCur(6);
        ListNodeCur l2 = new ListNodeCur(5);
        l22.next = l222;
        l2.next = l22;
        System.out.println();

        System.out.println(addTwoNumbers(l1, l2));
    }
}

class ListNodeCur {
    int val;
    ListNodeCur next;

    ListNodeCur(int x) {
        val = x;
    }
}
