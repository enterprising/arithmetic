package net.tanpeng.arithmetic.leetcode;

import java.util.Stack;

/**
 * @author: peng.tan
 * @create: 2021/03/13 23:27
 */
public class T1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty() || stack.peek() != S.charAt(i)) {
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
