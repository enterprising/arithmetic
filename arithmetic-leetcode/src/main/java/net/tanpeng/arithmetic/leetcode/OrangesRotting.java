package net.tanpeng.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrangesRotting {
    public static int orangesRotting(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;

        if (!Arrays.deepToString(grid).contains("1") && Arrays.deepToString(grid).contains("2")) {
            return result;
        }
        if (!Arrays.deepToString(grid).contains("1") && !Arrays.deepToString(grid).contains("2")) {
            return result;
        }
        boolean flagX = true;
        while (flagX) {
            result++;
            flagX = false;
            Set<String> newPoins = new HashSet<>();
            // 行
            for (int i = 0; i < grid.length; i++) {
                // 列
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2 && !newPoins.contains(i + "-" + j)) {
                        // 四个方位都赋值为2
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            newPoins.add((i - 1) + "-" + j);
                            flagX = true;
                        }
                        if (i + 1 < row && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 2;
                            newPoins.add((i + 1) + "-" + j);
                            flagX = true;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            newPoins.add(i + "-" + (j - 1));
                            flagX = true;
                        }
                        if (j + 1 < col && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 2;
                            newPoins.add(i + "-" + (j + 1));
                            flagX = true;
                        }
                    }
                }
            }
            boolean flag = true;
            for (int[] ints : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (ints[j] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid = new int[][]{{0, 2}};
        orangesRotting(grid);
    }
}
