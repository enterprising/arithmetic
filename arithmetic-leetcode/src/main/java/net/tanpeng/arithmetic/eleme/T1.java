package net.tanpeng.arithmetic.eleme;

/**
 * Created by peng.tan on 2019/4/18.
 */
public class T1 {
    public static void main(String[] args) {
        // 遍历1-100，被3整除的输出a, 被5整除的输出b，被15整除的输出c。
        // 这里最关键的是被15整除的，就不用再考虑3和5了
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("c");
            } else if (i % 3 == 0) {
                System.out.println("a");
            } else if (i % 5 == 0) {
                System.out.println("b");
            }
            System.out.println(i + "-----\n");
        }
    }
}
