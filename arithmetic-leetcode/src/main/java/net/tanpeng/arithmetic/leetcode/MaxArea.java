package net.tanpeng.arithmetic.leetcode;

/**
 * Created by peng.tan on 2021/6/27 11:03 上午
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int max = -1;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (left < 0 || right >= height.length) {
                break;
            }
            int maxTemp = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, maxTemp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
