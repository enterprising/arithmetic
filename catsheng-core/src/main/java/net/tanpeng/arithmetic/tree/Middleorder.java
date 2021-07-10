package net.tanpeng.arithmetic.tree;

import java.util.Stack;

/**
 * 中序遍历 左根右
 * Created by peng.tan on 2019/2/16.
 */
public class Middleorder {
    /**
     * 递归版
     *
     * @param root
     */
    private static void recursionMiddleorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            System.out.print(root.value + " ");
            recursionMiddleorderTraversal(root.right);
        }
    }

    /**
     * 非递归版
     *
     * @param root
     */
    private static void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initForTest();
        recursionMiddleorderTraversal(root);
        System.out.println();
        middleorderTraversal(root);
    }
}
