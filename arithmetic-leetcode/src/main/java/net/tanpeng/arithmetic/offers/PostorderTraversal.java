package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: peng.tan
 * @create: 2020/05/02 16:18
 */
public class PostorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        dg(root);
        return result;
    }

    private void dg(TreeNode root) {
        if (root == null) {
            return;
        }
        dg(root.left);
        dg(root.right);
        result.add(root.val);
    }
}
