package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/05/03 22:37
 */
public class Fibonacci {
    /**
     * 递归太多重复计算了，最好用迭代
     */
    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int Fibonacci2(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int lastlastValue = 0;
        int lastValue = 1;
        for (int i = 2; i <= n; i++) {
            result = lastValue + lastlastValue;
            lastlastValue = lastValue;
            lastValue = result;
        }
        return result;
    }

    public static int Fibonacci3(int n) {
        int[] result = new int[n + 1];
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }


    public static int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }


    public static int fibonacciFinal(int n) {
        if (n <= 1) {
            return n;
        }
        int result = 0;
        int prePre = 0;
        int pre = 1;
        System.out.println(pre);
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciFinal(5));
    }
}
