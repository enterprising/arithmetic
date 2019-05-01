package net.tanpeng.arithmetic.emeeasy;

import java.util.HashMap;
import java.util.Map;

/**
 * 7. 单词计数，输入一个字符串数组，统计每个单词出现的次数。
 * * given ["boy","girl","boy"], return boy:2, girl:1
 * * 点评: 数据结构考察，用个map保存一下key，value即可，还是很简单的。
 * Created by peng.tan on 2019/4/18.
 */
public class T7 {
    public static void main(String[] args) {
        String[] s = new String[]{"boy", "girl", "boy"};
        Map<String, Integer> map = new HashMap<>();

        for (String x : s) {
            map.compute(x, (k, v) -> v == null ? 1 : v + 1);
        }

        System.out.println(map);
    }
}
