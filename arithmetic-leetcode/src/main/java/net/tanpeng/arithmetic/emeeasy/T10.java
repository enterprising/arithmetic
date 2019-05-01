package net.tanpeng.arithmetic.emeeasy;

/**
 * 10. 一个排好序的数组(升序)，给一个数字，判断数组中是否有两个数加起来=给定的数字
 * array=[1,2,3,4,5], given target=8, return true(3+5==8), given 10, return false;
 * 点评: 要求o(n)复杂度，两个指针，遍历一遍就行了。
 */
public class T10 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int target = 9;

        // o(n)的复杂度，那肯定不能两重循环
        // 需要考虑前后各一个指针
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            if (a[low] + a[high] == target) {
                System.out.println("ok");
                break;
            } else if (a[low] + a[high] > target) {
                high--;
            } else {
                low++;
            }
        }
    }
}
