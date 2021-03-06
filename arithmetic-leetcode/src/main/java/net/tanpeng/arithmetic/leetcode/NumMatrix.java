package net.tanpeng.arithmetic.leetcode;

/**
 * @author: peng.tan
 * @create: 2021/03/02 22:45
 */
public class NumMatrix {
    public int[][] dps;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        dps = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dps[i][j + 1] = dps[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int row = row1; row <= row2; row++) {
            result += dps[row][col2 + 1] - dps[row][col1];
        }
        return result;
    }
}
