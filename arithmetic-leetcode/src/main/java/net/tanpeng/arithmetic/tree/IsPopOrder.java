package net.tanpeng.arithmetic.tree;

import java.util.Stack;

/**
 * @author: peng.tan
 * @create: 2020/05/05 12:23
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length == 0) {
            return false;
        }
        // 借助工具栈，模拟入栈出栈
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
