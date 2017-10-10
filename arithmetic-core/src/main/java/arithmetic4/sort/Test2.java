package arithmetic4.sort;

/**
 * Created by peng.tan on 17/10/9.
 */

public class Test2 {


    public static void main(String[] args) {
        int[] a = new int[]{8, 12, 14, 17, 26, 27, 28, 35, 36, 44, 44, 48, 54};
        a = mergeSort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] mergeSort(int[] a, int n) {
        sort(a, 0, n - 1);
        return a;
    }

    // 递归
    public static void sort(int[] a, int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        // 新建临时数组
        int[] temp = new int[a.length];
        for (int k = low; k <= high; k++) {
            temp[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid)
                a[k] = temp[j++];
            else if (j > high)
                a[k] = temp[i++];
            else if (a[j] < a[i])
                a[k] = temp[j++];
            else
                a[k] = temp[i++];
        }

    }

}