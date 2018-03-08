package net.tanpeng.arithmetic.offers;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 剑指Offer第65题：滑动窗口的最大值
 * <p>
 * 题目描述：
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 考点：队列
 */
public class T65 {

    /**
     * 使用双端队列进行取巧操作，具体思路见《剑指Offer》第292页
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList result = new ArrayList();
        if (size < 1 || num.length < size)
            return result;
        // 双端队列
        ArrayDeque<Integer> deque = new ArrayDeque();
        //先判断 0 - size
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }

        for (int i = size; i < num.length; i++) {
            result.add(num[deque.peekFirst()]);
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();
            if (!deque.isEmpty() && deque.peekFirst() <= i - size)
                deque.pollFirst();
            deque.offerLast(i);
        }
        result.add(num[deque.peekFirst()]);
        return result;
    }


    /**
     * 时间复杂度特别高的方法
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList result = new ArrayList();
        if (size < 1)
            return result;
        int maxItem;
        for (int i = 0; i < num.length - size + 1; i++) {
            maxItem = num[i];
            for (int j = i + 1; j < i + size; j++) {
                if (num[j] > maxItem)
                    maxItem = num[j];
            }
            result.add(maxItem);
        }

        return result;
    }
}
