package net.tanpeng.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 这题的主要思路是，数组里面的item，有个对应的target-item表示目标值
 * 如果剩下的里面有这个目标值，那么就说明是这一对
 * map。key是target-item，value是下标，这样值会好取一点
 * Created by peng.tan on 2020/1/27.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result);
    }
}
