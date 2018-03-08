package net.tanpeng.arithmetic.offers;

/**
 * 约瑟夫环
 */
public class Demo {

    public static int findLastNumber(int n, int m) {
        if (n < 1 | m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {
            i++;
            if (i >= n)
                i = 0; //这个是为了模拟环
            if (array[i] == -1)
                continue;
            step++;
            if (step == m) {
                array[i] = -1;
                count--;
                step = 0;
            }
        }
        return i;
    }


    public static void main(String[] args) {

    }
}
