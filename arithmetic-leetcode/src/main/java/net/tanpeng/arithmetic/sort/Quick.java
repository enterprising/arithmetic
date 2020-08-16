package net.tanpeng.arithmetic.sort;

/**
 * 快速排序
 */
public class Quick {

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 4, 2, 7};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (high <= low)
            return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }


    //始终选定数组中的最后一个元素作为枢轴元素，
    // 设置指针 i 初始值为数组起始元素索引减1，设置指针 j 由数组下标从低到高扫描整个数组，
    // 若遇到的元素小于枢轴元素则 i 自增然后交换 i 数组元素的值和 j 数组元素的值；
    // 若遇到的元素大于 枢轴元素则i指针不动，只有j指针自增。此算法的时间复杂度为O(n),空间复杂度为O(1)。
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                SortUtil.exch(a, i, j);
            }
        }
        SortUtil.exch(a, i + 1, high);
        return i + 1;
    }


    // 快排的核心 - 切分算法 (算法4里面的实现)
    private static int partition2(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = a[low]; // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (SortUtil.less(a[++i], v))
                if (i == high)
                    break;
            while (SortUtil.less(v, a[--j]))
                if (j == low)
                    break;
            if (i >= j)
                break;
            SortUtil.exch(a, i, j);
        }
        SortUtil.exch(a, low, j);
        return j;
    }
}
