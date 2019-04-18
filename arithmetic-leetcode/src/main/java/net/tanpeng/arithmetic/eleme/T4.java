package net.tanpeng.arithmetic.eleme;

/**
 * 判断一个字符串是不是回文, given "abcba" return true， given "abcab" return false;
 * 点评: 超级简单有木有，最多5分钟，不能再多了。
 * Created by peng.tan on 2019/4/18.
 */
public class T4 {

    public static void main(String[] args) {
        String a = "abcba";

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
                System.out.println("不是");
                return;
            }
        }
        System.out.println("是");
    }
}
