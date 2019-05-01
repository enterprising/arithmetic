package net.tanpeng.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng.tan on 2019/4/30.
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class T13 {
    public static int romanToInt(String s) {
        /*
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */
        Map<Character, Integer> route = new HashMap<>();
        route.put('I', 1);
        route.put('V', 5);
        route.put('X', 10);
        route.put('L', 50);
        route.put('C', 100);
        route.put('D', 500);
        route.put('M', 1000);

        long result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length) {
                result = result + route.get(chars[i]);
                break;
            }
            if (chars[i] == 'I' && chars[i + 1] == 'V') {
                result = result + 4;
                i++;
                continue;
            }
            if (chars[i] == 'I' && chars[i + 1] == 'X') {
                result = result + 9;
                i++;
                continue;
            }
            if (chars[i] == 'X' && chars[i + 1] == 'L') {
                result = result + 40;
                i++;
                continue;
            }
            if (chars[i] == 'X' && chars[i + 1] == 'C') {
                result = result + 90;
                i++;
                continue;
            }
            if (chars[i] == 'C' && chars[i + 1] == 'D') {
                result = result + 400;
                i++;
                continue;
            }
            if (chars[i] == 'C' && chars[i + 1] == 'M') {
                result = result + 900;
                i++;
                continue;
            }
            result = result + route.get(chars[i]);
        }
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        return Integer.parseInt(result + "");
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MDCXCV"));
    }
}
