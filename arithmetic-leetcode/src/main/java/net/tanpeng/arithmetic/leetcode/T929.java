package net.tanpeng.arithmetic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 * <p>
 * Created by peng.tan on 2019/4/16.
 */
public class T929 {
    public static int numUniqueEmails(String[] emails) {

        Set<String> result = new HashSet<>();

        for (String email : emails) {
            String[] item = email.split("@");
            StringBuilder sb = new StringBuilder();
            for (Character character : item[0].toCharArray()) {
                if (character == '.') {
                    continue;
                } else if (character == '+') {
                    break;
                } else {
                    sb.append(character);
                }
            }
            result.add(sb.toString() + "@" + item[1]);

        }

        return result.size();
    }

    public static void main(String[] args) {
        String[] x = new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails(x));
    }
}
