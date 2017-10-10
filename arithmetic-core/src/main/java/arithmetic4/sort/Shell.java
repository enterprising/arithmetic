package arithmetic4.sort;

/**
 * 希尔排序
 * 优化后的插入排序，不通点在于步长
 */
public class Shell {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        shell(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void shell(int[] a) {
        int n = a.length;
        int h = 1; //步长

        while (h < n / 3)
            h = h * 3 + 1;

        while (h >= 1) {
            // 这里其实就是插入排序了
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (SortUtil.less(a[j], a[j - h])) {
                        SortUtil.exch(a, j, j - h);
                    }
                }
            }
            h = h / 3;
        }
    }
}
