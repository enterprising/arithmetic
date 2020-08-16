package net.tanpeng.arithmetic.sort;

/**
 * Created by peng.tan on 17/10/9.
 */

public class MergeTest {

    public static void main(String[] args) {
        int[] a = new int[]{8, 12, 14, 17, 26, 27, 28, 35, 36, 44, 44, 48, 54};
        a = mergeSort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] mergeSort(int[] a, int n) {
        // write code here

        mergesort(a, 0, n - 1);

        return a;
    }


    public static void mergesort(int[] a, int low, int high) {
        // 递归的终点
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        mergesort(a, low, mid);
        mergesort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(int[] a, int low, int mid, int high) {
        //边界判断等，暂时先不管

        //代表两个数组的下标
        int i = low;
        int j = mid + 1;

        //新建临时表，方式交换后，影响整体的排序
        int[] temp = new int[a.length];
        for (int p = low; p <= high; p++) {
            temp[p] = a[p];
        }


        for (int k = low; k <= high; k++) {
            // 左边表用尽了，则全用右边的表补上
            if (i > mid) {
                a[k] = temp[j++];
            }
            // 右边表用尽了，则用左边的表补上
            else if (j > high) {
                a[k] = temp[i++];
            }
            // 小的进去
            else if (a[j] < a[i]) {
                a[k] = temp[j++];
            } else
                a[k] = temp[i++];
        }


    }


    public static void merge_better(int[] a, int low, int mid, int high) {
        //边界判断等，暂时先不管

        //代表两个数组的下标
        int i = low;
        int j = mid + 1;

        //新建临时表，方式交换后，影响整体的排序
        int[] temp = new int[high - low + 1];
        for (int p = low; p <= high; p++) {
            temp[p - low] = a[p];
        }


        for (int k = low; k <= high; k++) {
            // 左边表用尽了，则全用右边的表补上
            if (i > mid) {
                a[k] = temp[j++ - low];
            }
            // 右边表用尽了，则用左边的表补上
            else if (j > high) {
                a[k] = temp[i++ - low];
            }
            // 小的进去
            else if (a[j] < a[i]) {
                a[k] = temp[j++ - low];
            } else
                a[k] = temp[i++ - low];
        }


    }
}
