package net.tanpeng.arithmetic.offers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: peng.tan
 * @create: 2020/04/26 20:46
 */
public class T3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
