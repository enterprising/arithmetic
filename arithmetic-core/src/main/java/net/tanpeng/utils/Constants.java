package net.tanpeng.arithmetic.leetcode;

/**
 * Created by peng.tan on 2021/5/9 10:33 下午
 */
public class Constants {
    public static final String c1 = "C1";

    static {
        System.out.println("Constants Class Loaded！");
    }

    public static void main(String[] args) {

        String c1 = Constants.c1;
        System.out.println(c1);

    }
}