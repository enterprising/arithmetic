package net.tanpeng.arithmetic.tree;

import java.util.Stack;

/**
 * 后序遍历 左右根
 * Created by peng.tan on 2019/2/16.
 */
public class Postorder {
    /**
     * 递归版
     */
    private static void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostorderTraversal(root.left);
            recursionPostorderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    /**
     * 非递归版
     * 这个比较复杂，因为是否可以输出当前节点取决于左右子树是否都遍历完成
     * 所以用了一个lastVisit。若lastVisit等于当前考查节点的右子树，表示该节点的左右子树都已经遍历完成，则可以输出当前节点。
     */
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.value + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initForTest();
        recursionPostorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }
}
