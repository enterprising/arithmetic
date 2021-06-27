package net.tanpeng.arithmetic.tree;

import net.tanpeng.arithmetic.offers.TreeNode;

/**
 * @author: peng.tan
 * @create: 2020/05/04 21:23
 */
public class HasSubtree {
    /**
     * 判断root2是否是root1的子树
     * 这道题的关键在于，边界 + 递归
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean isFind = false;
        // 找到左边跟右边root节点相等的节点，再开始递归
        if (root1.val == root2.val) {
            isFind = dg(root1, root2);
        }
        if (!isFind) {
            isFind = HasSubtree(root1.left, root2);
        }
        if (!isFind) {
            isFind = HasSubtree(root1.right, root2);
        }
        return isFind;
    }

    private boolean dg(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return dg(node1.left, node2.left) && dg(node1.right, node2.right);
    }
}
