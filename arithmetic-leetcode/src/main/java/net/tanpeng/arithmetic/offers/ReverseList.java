package net.tanpeng.arithmetic.offers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        // 1->2->3->4
        // 4->3->2->1
        ListNode prev = null;
        while (head != null) {
            // 先记录下一个节点，因为当前节点会变化
            ListNode nextNode = head.next;
            // 将当前的下一个节点指向此前记录的prev节点，第一次prev为NULL
            head.next = prev;
            // 记录prev节点为当前节点，方便下一次使用
            prev = head;
            // 当前节点指向后面一个，表示往后移动了一个节点
            head = nextNode;
        }
        return prev;
    }

    /**
     * 基于栈的实现
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode headResult = result;
//        Stack<Integer> stack = new Stack<>();
        // 用deque+linkedlist来模拟栈
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
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

