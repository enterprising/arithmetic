package net.tanpeng.arithmetic.offers;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        }
        int result = 0;
        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                tempMap.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
                Character k = entry.getKey();
                Integer v = entry.getValue();
                if (!map.containsKey(k)) {
                    flag = false;
                    break;
                }
                if (v > map.get(k)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        countCharacters(new String[2], "xasdsaq");
    }
}
