package net.tanpeng.arithmetic.leetcode;

import java.util.PriorityQueue;

/**
 * 利用优先级队列，实现数据中第k大的元素
 * @author: peng.tan
 * @create: 2021/03/14 20:41
 */
public class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int item : nums) {
            add(item);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
