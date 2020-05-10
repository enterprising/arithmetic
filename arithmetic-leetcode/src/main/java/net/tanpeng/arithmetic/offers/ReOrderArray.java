package net.tanpeng.arithmetic.offers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: peng.tan
 * @create: 2020/05/04 19:06
 */
public class ReOrderArray {
    /**
     * 奇数在前，偶数在后
     *
     * @param array
     */
    public static void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                right.add(array[i]);
            } else {
                left.add(array[i]);
            }
        }
        left.addAll(right);
        for (int i =0;i<array.length;i++){
            array[i]= left.get(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}
