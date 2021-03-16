package net.tanpeng.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 *
 * @author: peng.tan
 * @create: 2021/03/14 21:21
 */
public class T98 {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        recu(root);

        for (int i = 1; i <= list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void recu(TreeNode root) {
        if (root == null) {
            return;
        }
        recu(root.left);
        list.add(root.val);
        recu(root.right);
    }
}
