package net.tanpeng.arithmetic.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
            Map<Character, Integer> map = new HashMap<>();
            map.put(str[i], i);
            int tempMax = 1;
            for (int j = i + 1; j < str.length; j++) {
                if (map.containsKey(str[j])) {
                    i = map.get(str[j]);
                    break;
                }
                map.put(str[j], j);
                tempMax++;
            }
            max = Math.max(tempMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
