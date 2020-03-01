package net.tanpeng.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int result = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty()) {
            return 0;
        }
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int result = queue1.peek();
        queue2.offer(queue1.poll());
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println();
    }
}
