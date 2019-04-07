package net.tanpeng.arithmetic.offers;

/**
 * 二进制中1的个数
 * <p>
 * Created by peng.tan on 2019/3/30.
 */
public class T10 {
    public static void main(String[] args) {
        T10 t = new T10();
        System.out.println(t.NumberOf1(10));
    }

    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
                System.out.println(n & flag);
            }
            flag = flag << 1;
        }
        return count;
    }
}
