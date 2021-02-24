package net.tanpeng.arithmetic.leetcode;

/**
 * @author: peng.tan
 * @create: 2021/02/24 21:57
 */
public class D0224 {
    public int[][] flipAndInvertImage(int[][] A) {
        // 先翻转，再反转
        int cols = A[0].length;
        for (int i = 0; i < A.length; i++) {
            if (cols % 2 != 0) {
                A[i][cols / 2] = A[i][cols / 2] == 1 ? 0 : 1;
            }
            for (int j = 0; j < cols / 2; j++) {
                // 交换顺序并反转
                int temp = A[i][j] == 1 ? 0 : 1;
                A[i][j] = A[i][cols - j - 1] == 1 ? 0 : 1;
                A[i][cols - j - 1] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        new D0224().flipAndInvertImage(A);
    }
}
