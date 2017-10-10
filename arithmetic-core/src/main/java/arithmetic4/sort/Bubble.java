package arithmetic4.sort;

/**
 * 冒泡排序
 */
public class Bubble {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (SortUtil.less(a[j], a[j - 1]))
                    SortUtil.exch(a, j, j - 1);
            }
        }
    }
}
