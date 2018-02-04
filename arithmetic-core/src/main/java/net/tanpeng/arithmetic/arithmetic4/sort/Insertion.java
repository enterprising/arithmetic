package net.tanpeng.arithmetic.arithmetic4.sort;

/**
 * 插入排序
 */
public class Insertion {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        insertSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtil.less(a[j], a[j - 1]))
                    SortUtil.exch(a, j, j - 1);
            }
        }
    }

}
