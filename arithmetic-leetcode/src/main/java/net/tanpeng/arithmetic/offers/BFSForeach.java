package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的层次遍历 BFS
 *
 * @author: peng.tan
 * @create: 2020/03/29 23:06
 */
public class BFSForeach {

    List<List<Integer>> levels = new ArrayList<>();

    public void helper(TreeNode node, int level) {
        // 初始化那一层，这里==level主要是第一次进来下一层那时候
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        // 递归进来的时候，永远都是遍历的那一层
        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

}
