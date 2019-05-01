package net.tanpeng.arithmetic.ememiddle;

/**
 * 1. 有一个排好序的数组(升序)，给定一个数字，找出这个数字在这个数组中第一次出现的index，如果不在数组中则返回-1.
 * 比如array=[1,2,2,3,4,5], target=2, return 1(第一次出现2的数组下标是1)
 * 点评: 算法复杂度要求log(n)，即要求候选人用二分查找来做，
 * 与经典的二分查找不一样，要求是要返回第一次出现该数字的index，只会'背'二分查找的同学是很难写出来的
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T1 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 4, 5, 9, 11};
        int target = 2;

        int low = 0;
        int high = a.length - 1;
        int mid = low / 2 + high / 2;
        int result = 0;
        while (low < high) {
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low++;
            } else {
                result = mid;
                high--;
            }
            mid = low / 2 + high / 2;
        }
        System.out.println(result);
    }
}
