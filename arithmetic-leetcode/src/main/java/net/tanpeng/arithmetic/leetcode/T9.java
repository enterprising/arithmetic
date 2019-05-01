package net.tanpeng.arithmetic.leetcode;

/**
 * 判断回文
 * https://leetcode.com/problems/palindrome-number/description/
 * Created by peng.tan on 2019/4/30.
 */
public class T9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] xchar = String.valueOf(x).toCharArray();
        for (int i = 0; i < xchar.length; i++) {
            if (xchar[i] != xchar[xchar.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
