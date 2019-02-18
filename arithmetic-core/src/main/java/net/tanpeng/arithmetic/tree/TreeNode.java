package net.tanpeng.arithmetic.tree;

/**
 * Created by peng.tan on 2019/2/16.
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        value = x;
    }

    /**
     * 图见：https://www.jianshu.com/p/456af5480cee
     * @return
     */
    public static TreeNode initForTest() {
        TreeNode treeNode6 = new TreeNode(6);
        treeNode6.left = new TreeNode(7);
        treeNode6.right = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode4.right = treeNode6;

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode4;

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.right = new TreeNode(5);
        treeNode.right = treeNode3;
        return treeNode;
    }
}
