package net.tanpeng.arithmetic.leetcode;

/**
 * @author: peng.tan
 * @create: 2021/03/06 14:16
 */
public class D0306 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int[] temp = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
            temp[i + nums.length] = nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boolean isFind = false;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[j] > nums[i]) {
                    result[i] = temp[j];
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new D0306().nextGreaterElements(new int[]{1, 2, 1});
    }
}
