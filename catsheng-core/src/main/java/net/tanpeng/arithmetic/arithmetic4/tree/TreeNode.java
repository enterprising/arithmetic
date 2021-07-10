package net.tanpeng.arithmetic.arithmetic4.tree;

/**
 * 二叉树的结点类型
 */
public class TreeNode {
    // 用于排序的key
    int key;
    // key对应的value
    int value;
    //表示当前节点为根的子节点总数
    int n;

    TreeNode left;
    TreeNode right;

    TreeNode(int key, int value, int n) {
        this.key = key;
        this.value = value;
        this.n = n;
    }
}
