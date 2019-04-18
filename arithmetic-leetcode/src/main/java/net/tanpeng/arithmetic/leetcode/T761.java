package net.tanpeng.arithmetic.leetcode;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * 我感觉可以先排序，然后中间那个数肯定就是要找的数
 * Created by peng.tan on 2019/4/18.
 */
public class T761 {
    public int repeatedNTimes(int[] A) {
        // 先来一把快排，快排最关键的在于找中枢值
        int low = 0;
        int high = A.length - 1;
        quickSort(A, low, high);

        // 加入中间不是那个数，则需要比较
        if (A.length > 2 && A.length % 2 == 0) {
            if (A[A.length / 2] == A[A.length / 2 + 1]) {
                return A[A.length / 2];
            } else {
                return A[A.length / 2 - 1];
            }
        }
        return A[A.length / 2];
    }

    private void quickSort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        quickSort(a, low, j - 1);
        quickSort(a, j + 1, high);
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int small = low - 1;
        for (int i = low; i < high; i++) {
            if (a[i] <= pivot) {
                small++;
                // 交换small和i的位置
                int temp = a[i];
                a[i] = a[small];
                a[small] = temp;
            }
        }
        // 结束之后，交换small+1和high
        int temp = a[small + 1];
        a[small + 1] = pivot;
        a[high] = temp;
        // 这个就是中枢值
        return small + 1;
    }

    public static void main(String[] args) {
        T761 t761 = new T761();
        System.out.println(t761.repeatedNTimes(new int[]{2, 4, 3, 3, 5, 3}));
    }
}
