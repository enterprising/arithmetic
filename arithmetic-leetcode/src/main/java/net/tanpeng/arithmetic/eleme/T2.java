package net.tanpeng.arithmetic.eleme;

/**
 * Created by peng.tan on 2019/4/18.
 */
public class T2 {
    //输入一个字符串，全是大写字母范围从'A'-'Z'(A,B,C,D,AA,AB,AC)，输出相应的int值. (A=1,B=2,Z=26,AA=27...)
    //点评: 就是考察了一下 sum = sum * 26 + curr;
    // 本质上是26进制
    public static void main(String[] args) {
        String s = "ADSFE";
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                continue;
            }
            sum = sum * 26 + (c - 'A') + 1;
        }
        System.out.println(sum);
    }
}
