package net.tanpeng.arithmetic.leetcode;

/**
 * https://leetcode.com/problems/to-lower-case/
 * <p>
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * Created by peng.tan on 2019/4/15.
 */
public class T709 {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char x : str.toCharArray()) {
            if ((int) x <= 90 && (int) x >= 64) {
                sb.append((char) ((int) x + 32));
            } else {
                sb.append(x);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T709 t709 = new T709();
        t709.toLowerCase("AACVCASDqwAa");
    }
}

