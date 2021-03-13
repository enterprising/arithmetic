package net.tanpeng.arithmetic.leetcode;

import net.tanpeng.arithmetic.offers.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求树的最小深度。https://labuladong.gitee.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/BFS%E6%A1%86%E6%9E%B6.html
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
 * 这道题 dfs可以做，但bfs才是最优的
 *
 * @author: peng.tan
 * @create: 2021/03/08 22:41
 */
public class T111 {

    /**
     * dfs 解法
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 这里其中一个节点为空，说明 left 和 right 有一个必然为0，所以可以返回 left+right+1;
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // bfs核心就是用到队列，因为先进先出，每次处理完一层再说 (进循环前的 size 标识那段size是当前那层的)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root本身就是一层，所以deeps初始为1
        int deeps = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // !! 判断是否到终点
                if (cur.left == null && cur.right == null) {
                    return deeps;
                }
                // 将相邻节点加到队列中
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 循环完一次，进行deeps+1
            deeps++;
        }
        return deeps;
    }
}
