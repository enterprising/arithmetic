package net.tanpeng.arithmetic.ememiddle;

/**
 * 2. 把字符串转成int，即输入"123",输出123。(不允许用库函数，绝对不允许)
 * 点评: 很难的一道题目。各种边界考察，诸如正负号、非法字符、int越界。候选人考虑到的边界情况越多越好，不期望完全bugfree。
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T2 {

    public static void main(String[] args) {
        System.out.println(normal2("2333"));
        // Integer.parseInt("233"); 标准实现在这个库函数的方法里面
    }

    /**
     * 这个是不考虑越界问题的答案，这个还挺简单的
     *
     * @param str
     * @return
     */
    public static int normal2(String str) {
        boolean isNegative = false;
        str = str.trim();
        if (str.startsWith("-")) {
            isNegative = true;
        }
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            }
            sum = sum * 10 + (c - '0');
        }

        return isNegative ? -sum : sum;
    }

    /**
     * 在上面的基础上考虑了越界，这个是加分点
     *
     * @param str
     * @return
     */
    public static int normal22(String str) {
        boolean isNegative = false;
        str = str.trim();
        if (str.startsWith("-")) {
            isNegative = true;
        }
        int sum = 0;
        int multi = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            }
            if (sum > multi || ((sum == multi) && Integer.MAX_VALUE % 10 < (c - '0'))) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = sum * 10 + (c - '0');
        }

        return isNegative ? -sum : sum;
    }
}
