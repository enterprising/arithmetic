package net.tanpeng.arithmetic.leetcode;

/**
 * 动态规划（数组区间）---数组区间和
 * https://www.cnblogs.com/yjxyy/p/11116444.html
 *
 * @author: peng.tan
 * @create: 2020/11/03 20:26
 */
public class NumArray {

    public int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            // 计算当前sum值
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        // 逻辑判断
        return dp[j + 1] - dp[i];
    }

}
