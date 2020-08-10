package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 二叉搜索树是中序遍历的，有顺序的树。先把链表组起来，然后设置前后指针。
 * 这里需要在第一次遍历的时候存一下每个节点，包括节点的前后内容。
 *
 * @author: peng.tan
 * @create: 2020/08/09 22:36
 */
public class ConvertTree {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 中序遍历
        midroot(pRootOfTree);
        // 赋值，左右指针。最后一个不需要右指针了
        for (int i = 0; i < list.size() - 1; i++) {
            // 双向的
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }

        return list.get(0);
    }

    private void midroot(TreeNode root) {
        if (root == null) {
            return;
        }
        midroot(root.left);
        list.add(root);
        midroot(root.right);
    }
}
