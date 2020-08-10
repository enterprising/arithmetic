package net.tanpeng.arithmetic.offers;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 *
 * @author: peng.tan
 * @create: 2020/08/09 23:28
 */
public class CloneLinkList {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode result = new RandomListNode(pHead.label);
        // cur 用来第二次移动 phead
        RandomListNode cur = pHead;

        // p 用来移动 result
        RandomListNode p = result;

        while (pHead != null) {
            map.put(pHead, new RandomListNode(pHead.label));
            pHead = pHead.next;
        }

        while (cur != null) {
            p.next = map.get(cur.next);
            p.random = map.get(cur.random);

            cur = cur.next;
            p = p.next;
        }

        return result;
    }


}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}