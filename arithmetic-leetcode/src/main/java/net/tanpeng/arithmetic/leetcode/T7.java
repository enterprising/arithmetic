package net.tanpeng.arithmetic.leetcode;

/**
 * 数字反转
 * https://leetcode.com/problems/reverse-integer/description/
 * Created by peng.tan on 2019/4/30.
 */
public class T7 {
    /**
     * 我感觉最重要的在于考虑多种情况
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean isLTZero = String.valueOf(x).startsWith("-");
        StringBuilder sb = new StringBuilder();

        char[] xchar = String.valueOf(x).toCharArray();
        for (int i = String.valueOf(x).length() - 1; i >= 0; i--) {
            if (xchar[i] == '-') {
                continue;
            }
            sb.append(xchar[i]);
        }

        Long temp = Long.valueOf(sb.toString());
        if (temp > Integer.MAX_VALUE) {
            return 0;
        }
        int num = Integer.parseInt(sb.toString());
        return isLTZero ? num * -1 : num;
    }
}
