package net.tanpeng.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: peng.tan
 * @create: 2021/03/14 16:57
 */
public class T331 {
    public boolean isValidSerialization(String preorder) {
        //字符串的长度
        int n = preorder.length();
        //index,索引
        int i = 0;
        //搞一个栈
        Deque<Integer> stack = new LinkedList<Integer>();
        //先放一个数字1进去，代表当前可以消耗的槽位为1，因为我们开始遍历的时候，根节点会消耗一个槽位。
        stack.push(1);
        while (i < n) {
            //如果遍历途中，没有槽位可以消耗，说明序列化有问题。
            if (stack.isEmpty()) {
                return false;
            }
            //是个逗号就不管，直接i++
            if (preorder.charAt(i) == ',') {
                i++;
            }//遍历到一个#，消耗一个栈顶的槽位，如果槽位尚未消耗完毕，再将它塞进栈中去。
            else if (preorder.charAt(i) == '#') {
                //消耗一个槽位
                int top = stack.pop() - 1;
                //还有剩余，塞进去
                if (top > 0) {
                    stack.push(top);
                }
                //不要忘记继续遍历
                i++;
            }//遍历到数字了
            else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                //数字也要消耗一个槽位，同时一个数字会带来两个槽位，代表左右孩子。
                int top = stack.pop() - 1;
                //没消耗完的在塞进去，和上一个if判断理解一样
                if (top > 0) {
                    stack.push(top);
                }
                //将这个数字带来的槽位塞到栈中去。
                stack.push(2);
            }
        }
        //直至遍历结束，查看栈是否为空，为空就是true,否则，为false.
        return stack.isEmpty();
    }
}
