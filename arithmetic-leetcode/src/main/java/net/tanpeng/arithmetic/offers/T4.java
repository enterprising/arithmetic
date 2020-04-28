package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/04/27 21:39
 */
public class T4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }

}
