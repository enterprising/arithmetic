package net.tanpeng.arithmetic.offers;

import java.util.Stack;

/**
 * @author: peng.tan
 * @create: 2020/05/03 21:29
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
