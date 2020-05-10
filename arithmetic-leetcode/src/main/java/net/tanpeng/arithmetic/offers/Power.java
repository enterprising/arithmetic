package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/05/04 19:01
 */
public class Power {
    public double Power(double base, int exponent) {
        double result = 1;
        for (int i = 1; i <= Math.abs(exponent); i++) {
            result = result * base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }
}
