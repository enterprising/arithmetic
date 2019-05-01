package net.tanpeng.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 两数之和
 * Created by peng.tan on 2019/4/30.
 */
public class T2 {
    public static int[] twoSum(int[] nums, int target) {
        // key是 target-nums[a] , value是 a
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        nums = twoSum(nums, 9);
        System.out.println();
    }
}
