package net.tanpeng.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历，前左右
 *
 * @author: peng.tan
 * @create: 2020/04/28 23:15
 */
public class PreorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        rf(root);
        return result;
    }

    public void rf(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {

    }
}
