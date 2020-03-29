package net.tanpeng.arithmetic.leetcode;

/**
 * 树的深度优先遍历。DFS。寻找二叉树的最大深度
 *
 * @author: peng.tan
 * @create: 2020/03/29 18:44
 */
public class DFSMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return Math.max(leftHight, rightHight) + 1;
    }
}
