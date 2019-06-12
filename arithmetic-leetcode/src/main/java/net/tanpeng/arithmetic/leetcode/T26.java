package net.tanpeng.arithmetic.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by peng.tan on 2019/5/8.
 */
public class T26 {
    private int removeDuplicates(int[] nums) {
        int index = 0;
        Set<Integer> result = new TreeSet<>();
        for (int num : nums) {
            result.add(num);
        }
        for (Integer i : result) {
            nums[index++] = i;
        }
        return result.size();
    }

    public static void main(String[] args) {
        T26 t26 = new T26();
        t26.removeDuplicates(new int[]{1, 1, 2});
    }


}
