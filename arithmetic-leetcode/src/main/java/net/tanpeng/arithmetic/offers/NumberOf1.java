package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/05/04 15:05
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int result = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }
}
