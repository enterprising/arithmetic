package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;

/**
 * @author: peng.tan
 * @create: 2020/05/04 23:35
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        // 圈数
        int circle = ((row < col ? row : col) - 1) / 2 + 1;
        for (int i = 0; i < circle; i++) {
            // 左到右
            for (int j = i; j < col - i; j++) {
                result.add(matrix[i][j]);
            }
            // 上到下  col - 1 - i 这个是一个难点
            for (int k = i + 1; k < row - i; k++) {
                result.add(matrix[k][col - 1 - i]);
            }
            // 右往左，判断是否有重复打印，row - i - 1 != i
            for (int m = col - i - 2; (m >= i) && (row - i - 1 != i); m--) {
                result.add(matrix[row - i - 1][m]);
            }
            // 下往上，判断是否有重复打印，col-i-1!=i
            for (int n = row - i - 2; (n > i) && (col - i - 1 != i); n--) {
                result.add(matrix[n][i]);
            }
        }
        return result;
    }
}
