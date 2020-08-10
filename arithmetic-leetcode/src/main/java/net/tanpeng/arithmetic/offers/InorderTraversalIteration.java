package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历 迭代版本
 * 利用栈，左中右，找到最左边的栈放最上面
 *
 * @author: peng.tan
 * @create: 2020/05/02 16:34
 */
public class InorderTraversalIteration {
    public List<Integer> inOrderIteration(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            // 把当前节点压栈，再把左子树全压栈，这样最后栈顶就是最左边的节点了，接下来是中节点
            while (cur != null) {
                // 先中下去，下一轮就是左
                stack.push(cur);
                cur = cur.left;
            }
            // 左先出来
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                // 最后压栈的是右边的节点
                cur = treeNode.right;
            }
        }
        return result;
    }
}
