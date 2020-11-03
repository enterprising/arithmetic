package net.tanpeng.arithmetic.offers;

/**
 * 翻转二叉树
 *
 * @author: peng.tan
 * @create: 2020/11/03 21:57
 */
public class InvertNode {

    public TreeNode invertNode(TreeNode root) {
        if (root == null)
            return null;

        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            root.left = invertNode(root.left);
        }
        if (root.right != null) {
            root.right = invertNode(root.right);
        }
        return root;
    }

}
