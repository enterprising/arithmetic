package net.tanpeng.arithmetic.leetcode;

/**
 * https://leetcode.com/problems/remove-outermost-parentheses/
 * 移除最外层的括号
 * Created by peng.tan on 2019/4/14.
 */
public class T1021 {

    public String removeOuterParentheses(String s) {
        // 题目的意思大概就是移除最外面的括号，括号匹配用栈
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            // 首先，最外层，所以进来的是 ) ,然后flag=1表示是最外层，这时候算一个
            // 在上面的条件里，需要加上条件 flag!=0，因为flag==0表示是进来了 最外层的 (
            if (flag != 0 && !(x == ')' && flag == 1)) {
                sb.append(x);
            }
            if (x == '(') {
                flag++;
            } else {
                flag--;
            }
        }
        return sb.toString();
    }
}
