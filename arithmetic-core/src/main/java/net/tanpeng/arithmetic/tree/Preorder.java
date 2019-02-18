package net.tanpeng.arithmetic.tree;

import java.util.Stack;

/**
 * 二叉树的先序遍历 （根左右） 的递归版和非递归版实现
 * Created by peng.tan on 2019/2/16.
 */
public class Preorder {

    /**
     * 递归版
     *
     * @param root
     */
    private static void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    /**
     * 非递归版
     *
     * @param root
     */
    private static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();

        TreeNode node = root;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                System.out.print(node.value + " ");
                // 为了之后能找到该节点的右子树，所以需要暂存这个节点到栈里
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，才开始考虑又子树
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initForTest();
        recursionPreorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
    }
}
