package net.tanpeng.arithmetic.offers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: peng.tan
 * @create: 2020/10/07 07:52
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int anArray : array) {
            map.compute(anArray, (k, v) -> v == null ? 1 : v + 1);

            if (map.get(anArray) > array.length / 2) {
                return anArray;
            }
        }

        return 0;
    }
}
