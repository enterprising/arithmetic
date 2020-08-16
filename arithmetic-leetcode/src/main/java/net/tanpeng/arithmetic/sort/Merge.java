package net.tanpeng.arithmetic.sort;

/**
 * 归并排序
 */
public class Merge {

    private static int[] aux; //归并所需的辅助数组

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 4, 2, 7};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        // 将数组a[low..high]排序
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 将 a[low..mid] 和 a[mid...high]归并
     *
     * @param a    待合并的数组
     * @param low  起点
     * @param mid  中点
     * @param high 终点
     */
    private static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        // 将目标数据复制出来，防止造成数据混乱
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        //左半边用尽，取右半边的元素
        //右半边用尽，取左半边的元素
        //右半边的小于左半边的元素，取右半边的元素
        //右半边的大于左半边的元素，取左半边的元素
        for (int k = low; k <= high; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > high)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

}
