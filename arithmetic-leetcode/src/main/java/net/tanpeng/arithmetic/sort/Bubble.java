package net.tanpeng.arithmetic.sort;

/**
 * 冒泡排序
 * 每次都是比较相邻的两个元素，每一轮把最小的冒泡到最前面
 * 和选择排序有本质的不同，1、选择排序少了很多次交换的过程；2、选择排序是不稳定的，冒泡是稳定的
 */
public class Bubble {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (SortUtil.less(a[j], a[j - 1]))
                    SortUtil.exch(a, j, j - 1);
            }
        }
    }
}
