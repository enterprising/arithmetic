package net.tanpeng.arithmetic.leetcode;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * x的平方根
 *
 * @author: peng.tan
 * @create: 2021/03/01 23:01
 */
public class T69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
