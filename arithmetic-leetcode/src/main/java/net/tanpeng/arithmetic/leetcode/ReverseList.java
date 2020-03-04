package net.tanpeng.arithmetic.leetcode;

import java.util.Stack;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        // 1->2->3->4
        // 4->3->2->1
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            // 先记录下一个节点，因为当前节点会变化
            ListNode nextNode = curr.next;
            // 将当前的下一个节点指向此前记录的prev节点，第一次prev为NULL
            curr.next = prev;
            // 记录prev节点为当前节点，方便下一次使用
            prev = curr;
            // 当前节点指向后面一个，表示往后移动了一个节点
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 基于栈的实现
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode headResult =result;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()){
            result.next = new ListNode(stack.pop());
            result = result.next;
        }
        return headResult.next;
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
        reverseList(head);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

