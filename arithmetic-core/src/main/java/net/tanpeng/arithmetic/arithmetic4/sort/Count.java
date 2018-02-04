package net.tanpeng.arithmetic.arithmetic4.sort;

/**
 * 计数排序
 */
public class Count {
    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        countSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void countSort(int[] a) {
        int n = a.length;
        // 找到数组中的最大值
        int max = findMax(a);
        int[] result = new int[max + 1];
        for (int i = 0; i < n; i++) {
            result[a[i]]++;
        }
        int k = 0;//存放下标
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < result[i]; j++)
                a[k++] = i;
        }
    }

    private static int findMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max)
                max = i;
        }
        return max;
    }

}
