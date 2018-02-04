package net.tanpeng.arithmetic.arithmetic4.sort;


/**
 * 选择排序
 */
public class Selection {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        selectionSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtil.less(a[j], a[min]))
                    min = j;
            }
            SortUtil.exch(a, i, min);
        }
    }

}
