package net.tanpeng.arithmetic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by peng.tan on 2020/1/27.
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] str = s.toCharArray();
        int max = 1;
        for (int i = 0; i < str.length; i++) {
            Set<Character> set = new HashSet<>();
            set.add(str[i]);
            int tempMax = 1;
            for (int j = i + 1; j < str.length; j++) {
                if (set.contains(str[j])) {
                    break;
                }
                set.add(str[j]);
                tempMax++;
            }
            max = tempMax > max ? tempMax : max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbb"));
    }
}
