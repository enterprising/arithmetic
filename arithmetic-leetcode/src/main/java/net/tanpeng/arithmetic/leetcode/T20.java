package net.tanpeng.arithmetic.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * Created by peng.tan on 2019/5/5.
 */
public class T20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if (c == ')'&&stack.peek()=='(') {
                stack.pop();
                continue;
            }
            if (c == ']'&&stack.peek()=='[') {
                stack.pop();
                continue;
            }
            if (c == '}'&&stack.peek()=='{') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

}
