package net.tanpeng.arithmetic.ememiddle;

/**
 * 二分
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class TwoSplit {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 4, 5, 9, 11};
        int target = 9;

        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                System.out.println("在下标：" + mid + " : " + a[mid]);
                return;
            }
        }
        System.out.println("不存在");
    }
}
