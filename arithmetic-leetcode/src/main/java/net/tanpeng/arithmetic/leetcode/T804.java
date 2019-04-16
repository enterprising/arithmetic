package net.tanpeng.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-morse-code-words/
 * 莫斯科编码
 * Created by peng.tan on 2019/4/15.
 */
public class T804 {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<>();
        String[] x = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Map<String, Integer> result = new HashMap<>();

        int charindex = 97;
        for (String s : x) {
            System.out.println(s);
            map.put((char) charindex, s);
            charindex++;
        }

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char w : word.toCharArray()) {
                sb.append(map.get(w));
            }
            if (result.containsKey(sb.toString())) {
                result.put(sb.toString(), result.get(sb.toString()) + 1);
            } else {
                result.put(sb.toString(), 1);
            }

        }
        return result.keySet().size();
    }

    public static void main(String[] args) {
        T804 t804 = new T804();
        String[] x = new String[100];
        x[0] = "a";
        x[1] = "b";
        t804.uniqueMorseRepresentations(x);
    }
}
