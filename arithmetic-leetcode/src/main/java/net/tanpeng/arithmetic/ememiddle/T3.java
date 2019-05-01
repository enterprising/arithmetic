package net.tanpeng.arithmetic.ememiddle;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 给一个字符串，都是小写字母范围从'a'-'z', 其中有些字符出现了不止一次，
 * 删掉那些出现多次的字符，确保每个字符只出现一次。字符顺序不做要求。
 * 比如 "bcabc", 返回"bca"，或者"cab" 都是OK的。
 * 点评: 就是考察一下字符串的基本操作，对数据结构的理解。
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T3 {

    public static void main(String[] args) {
        String s = "bcabc";
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
            set.add(c);
        }

        System.out.println(sb.toString());
    }
}
