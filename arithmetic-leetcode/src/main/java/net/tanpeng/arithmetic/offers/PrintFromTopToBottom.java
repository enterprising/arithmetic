package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历，关键在于递归
 *
 * @author: peng.tan
 * @create: 2020/05/05 12:30
 */
public class PrintFromTopToBottom {
    List<List<Integer>> levels = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList arrayList = new ArrayList();
        if (root == null) {
            return arrayList;
        }
        // 递归去找
        helper(root, 0);
        levels.forEach(arrayList::addAll);
        return arrayList;
    }

    private void helper(TreeNode root, int level) {
        // 进来的时候，初始化。之所以不会被覆盖，是因为下次来的时候 levels的size就不等于level了
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        // 这里有个很重要的点在于 遍历的时候进来的，肯定是当前这一层
        levels.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
