package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/05/04 20:56
 */
public class MergeLinkList {
    /**
     * 链表合并
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode root = result;
        while (list1 != null || list2 != null) {
            ListNode curNode;
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    curNode = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    curNode = new ListNode(list2.val);
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                curNode = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                curNode = new ListNode(list1.val);
                list1 = list1.next;
            }
            result.next = curNode;
            result = result.next;
        }
        return root.next;
    }

    /**
     * 链表相加
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode MergeLink(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        while (list1 != null || list2 != null) {
            ListNode curNode;
            if (list1 != null && list2 != null) {
                curNode = new ListNode(list1.val + list2.val);
                list1 = list1.next;
                list2 = list2.next;
            } else if (list1 != null) {
                curNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                curNode = new ListNode(list2.val);
                list2 = list2.next;
            }
            listNode.next = curNode;
            listNode = listNode.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(6);

        System.out.println(MergeLink(listNode, listNode2));
        System.out.println(Merge(listNode, listNode2));
    }
}
