package net.tanpeng.arithmetic.offers;

public class DiameterOfBinaryTree {
    private static int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        depth(root);
        return max - 1;
    }

    /**
     * 深度遍历，加一层判断
     *
     * @param root
     */
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);  // 1、左
        int right = depth(root.right);  // 2、右
        max = left + right + 1 > max ? left + right + 1 : max; // 4、更新最大值
        return Math.max(left, right) + 1;  //  3、深度
    }


    public static void main(String[] args) {
        // 我的思路是左右递归
        TreeNode tree = new TreeNode(1);

    }

}
