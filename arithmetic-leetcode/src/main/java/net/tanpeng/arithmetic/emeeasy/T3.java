package net.tanpeng.arithmetic.emeeasy;

/**
 * Created by peng.tan on 2019/4/18.
 */
public class T3 {
    //3. 求两个数的最大公约数
    //点评: 如果候选人知道辗转相除法，应该还是比较简单的。否则可能就写不出来了，
    // 面试官还是根据候选人的实际情况，看看要不要考察这道题目。
    public static void main(String[] args) {

        int a = 123456;
        int b = 7890;

        int maxGongyueshu = calMaxXX(a, b);
        System.out.println(maxGongyueshu);
    }

    /**
     * 辗转相除，大概就是 m = m % n , 然后 n = n % m
     */
    private static int calMaxXX(int m, int n) {
        while (true) {
            if ((m = m % n) == 0) {
                return n;
            }
            if ((n = n % m) == 0) {
                return m;
            }
        }
    }
}
