package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 迭代版本的前序遍历
 * 利用栈，后进先出， head->head,   right left -> left,right
 * 注意栈一定要放树节点，不要让val，不然没法进行树的节点转移
 *
 * @author: peng.tan
 * @create: 2020/04/28 23:48
 */
public class PreorderIteration {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> gongjuren = new Stack<>();
        gongjuren.push(root);
        while (!gongjuren.isEmpty()) {
            TreeNode treeNode = gongjuren.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                gongjuren.push(treeNode.right);
            }
            if (treeNode.left != null) {
                gongjuren.push(treeNode.left);
            }
        }
        return result;
    }
}
