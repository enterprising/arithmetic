package net.tanpeng.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author: peng.tan
 * @create: 2020/05/02 16:15
 */
public class InorderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        dg(root);
        return list;
    }

    private void dg(TreeNode root) {
        if (root == null) {
            return;
        }
        dg(root.left);
        list.add(root.val);
        dg(root.right);
    }
}
