package net.tanpeng.arithmetic.leetcode;

/**
 * @author: peng.tan
 * @create: 2021/02/21 18:59
 */
public class D0216 {
    public static void main(String[] args) {
        new D0216().arrayPairSum(new int[]{1, 4, 3, 2});
    }

    public int arrayPairSum(int[] nums) {
        int result = 0;
        nums = sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }

    private int[] sort(int[] nums) {
        // 先从简单的开始，选择排序
        nums = selection(nums);
        return nums;
    }

    private int[] selection(int[] nums) {
        // 每次都选择后面最小的，和前面的第i位交换
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            // 交换 i 和 minIndex 的值
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    private int[] quick(int[] a) {
        sortDigui(a, 0, a.length);
        return a;
    }

    private void sortDigui(int[] a, int low, int hight) {
        if (hight <= low) {
            return;
        }
        int j = partition(a, low, hight);
        sortDigui(a, low, j - 1);
        sortDigui(a, j + 1, hight);
    }

    private int partition(int[] a, int low, int hight) {
        int flag = a[hight];
        int index = low;
        for (int i = low; i < hight; i++) {
            if (a[i]<=flag){
                // 交换index和i
                index++;
            }
        }
        // 交换 index 和 high

        return index;
    }
}
