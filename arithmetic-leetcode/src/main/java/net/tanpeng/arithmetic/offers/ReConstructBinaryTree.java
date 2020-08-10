package net.tanpeng.arithmetic.offers;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历，还原一下二叉树
 * <p>
 * 这里最关键的在于递归，递归的出路在于每次前序的第一个都是root，然后中序根据root分左右，再分别递归
 *
 * @author: peng.tan
 * @create: 2020/05/03 21:03
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }

        // 递归进来的第一个就是根节点
        int rootVal = pre[0];

        if (pre.length == 1) {
            return new TreeNode(rootVal);
        }


        // 我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        int targetIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootVal) {
                targetIndex = i;
                break;
            }
        }

        // 左右递归
        // 递归先序遍历的左子树：Arrays.copyOfRange(pre, 1, targetIndex + 1)   start包括，end不包括 （前闭后开） 这里不从0开始，因为0是root
        // 递归中续遍历的左子树：Arrays.copyOfRange(in, 0, targetIndex))   这里不包括targetIndex 因为它是root
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, targetIndex + 1), Arrays.copyOfRange(in, 0, targetIndex));
        // 递归先序遍历的右子树，同上
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, targetIndex + 1, pre.length), Arrays.copyOfRange(in, targetIndex + 1, in.length));
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4};
        // 左闭右开
        int[] result = Arrays.copyOfRange(pre, 0, 3);
        System.out.println();
    }
}
