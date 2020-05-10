package net.tanpeng.arithmetic.offers;

import java.util.*;

/**
 * @author: peng.tan
 * @create: 2020/05/05 10:27
 */
public class MinNodeStack {
    private List<Integer> list = new ArrayList<>();
    private Stack stack = new Stack();

    public void push(int node) {
        stack.push(node);
        list.add(node);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int result = (int) stack.pop();
            list.remove(list.lastIndexOf(result));
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return (int) stack.peek();
        } else {
            return -1;
        }
    }

    public int min() {
        if (list.isEmpty()) {
            return -1;
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
