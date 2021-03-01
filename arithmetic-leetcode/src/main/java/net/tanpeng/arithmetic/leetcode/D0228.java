package net.tanpeng.arithmetic.leetcode;

/**
 * https://leetcode-cn.com/problems/monotonic-array/
 *
 * @author: peng.tan
 * @create: 2021/02/28 20:12
 */
public class D0228 {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }
        boolean up = A[0] < A[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            if (up && A[i] > A[i + 1]) {
                return false;
            }
            if (!up && A[i] < A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new D0228().isMonotonic(new int[]{1, 5, 4, 6, 7, 8, 9});
    }

}
