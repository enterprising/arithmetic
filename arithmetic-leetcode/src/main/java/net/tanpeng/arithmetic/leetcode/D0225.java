package net.tanpeng.arithmetic.leetcode;

/**
 * https://leetcode-cn.com/problems/transpose-matrix/
 *
 * @author: peng.tan
 * @create: 2021/02/28 19:57
 */
public class D0225 {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        new D0225().transpose(a);
    }
}
