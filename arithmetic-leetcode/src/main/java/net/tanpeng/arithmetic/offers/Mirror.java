package net.tanpeng.arithmetic.offers;

/**
 * 给定一个二叉树，求这个二叉树的镜像
 * 这里的本质上是递归，可以用先序遍历，然后交换左右子树的那个value
 * 不能用其他的遍历，比如是中序遍历，从中序遍历来看  先遍历左子树再根节点再右子树  题目要将左右结点交换  遍历右子树时  感觉会卡死在里面
 *
 * @author: peng.tan
 * @create: 2020/05/04 21:44
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先序遍历
        dg(root);
    }

    private void dg(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        System.out.println(root.val);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dg(root.left);
        dg(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Mirror().Mirror(root);
        System.out.println();
    }
}
