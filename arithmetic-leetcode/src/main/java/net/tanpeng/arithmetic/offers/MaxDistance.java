package net.tanpeng.arithmetic.offers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
 *
 * @author: peng.tan
 * @create: 2020/03/29 23:15
 */
public class MaxDistance {

    public int maxDistance(int[][] grid) {
        // 用来记录四周的坐标
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        // 所有的陆地入队列。队列里放的是坐标。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean hasOcean = false;
        int[] point = null;
        // 从陆地开始遍历，跑到最后的就是最远的海洋
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            // 遍历周边的四个框框
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n || grid[newx][newy] != 0) {
                    continue;
                }
                grid[newx][newy] = grid[x][y] + 1; // 用来标记访问过，这样就可以不用单独搞个东西来记录了
                hasOcean = true;
                queue.offer(new int[]{newx, newy});
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }

        return grid[point[0]][point[1]] - 1;
    }

}
