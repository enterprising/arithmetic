package java.net.peng.arithmetic.tree;

/**
 * 二叉树的结点类型
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this(x, null, null);
    }

    TreeNode(int x, TreeNode l, TreeNode r) {
        this.value = x;
        left = l;
        right = r;
    }
}
