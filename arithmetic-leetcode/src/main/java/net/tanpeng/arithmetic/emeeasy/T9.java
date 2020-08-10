package net.tanpeng.arithmetic.emeeasy;

/**
 * 这道题是朱老师必考的，朱老师说可以pass 70%的人
 * 9. 翻转链表
 * 点评: 老题目，不过如果没准备的话，翻起来也没那么容易
 */
public class T9 {

    public static LinkedNode easy9(LinkedNode head) {
        LinkedNode pre = null;
        while (head != null) {
            LinkedNode next = head.nextNode;
            head.nextNode = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(1);
        LinkedNode linkedNode2 = new LinkedNode(2);
        LinkedNode linkedNode3 = new LinkedNode(3);
        LinkedNode linkedNode4 = new LinkedNode(4);
        LinkedNode linkedNode5 = new LinkedNode(5);

        linkedNode.nextNode = linkedNode2;
        linkedNode2.nextNode = linkedNode3;
        linkedNode3.nextNode = linkedNode4;
        linkedNode4.nextNode = linkedNode5;
        easy9(linkedNode);
    }

}
