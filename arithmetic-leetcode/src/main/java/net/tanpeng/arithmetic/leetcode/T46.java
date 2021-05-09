package net.tanpeng.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 回溯算法
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author: peng.tan
 * @create: 2021/03/08 22:11
 */
public class T46 {
    static List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        // 记录走过的路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    /**
     * 回溯核心算法
     * <p>
     * 路径：track
     * 选择条件：nums中不在track里的对象
     * 结束条件：nums的对象全在track中
     */
    private void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        new T46().permute(nums);

        System.out.println(result);
        System.out.println();
    }
}
