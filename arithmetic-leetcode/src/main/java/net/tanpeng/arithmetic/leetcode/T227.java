package net.tanpeng.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对于加减号后的数字，将其直接压入栈中；对于乘除号后的数字，可以直接与栈顶元素计算，并替换栈顶元素为计算后的结果。
 *
 * @author: peng.tan
 * @create: 2021/03/14 11:47
 */
public class T227 {

    public int calculate(String s) {
        // Java推荐的创建栈的方式
        Deque<Integer> stack = new LinkedList<>();
        // 非个位数，因此需要算出来具体的数是什么
        int num = 0;
        Character preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}
