package net.tanpeng.arithmetic.eleme;

import java.util.Arrays;

/**
 * 有两个已经排好序的数组(升序)，现在把这两个数组合成一个按升序排列的数组。
 * * given array1=[1,3,5,7,9], given array2=[2,4,6,8,10], return newarray[1,2,3,4,5,6,7,8,9,10]
 * * 点评: 数组基本操作
 * Created by peng.tan on 2019/4/18.
 */
public class T6 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 5, 7, 9};
        int[] a2 = new int[]{2, 4, 6, 8, 10};

        // 感觉有点像归并？

        int[] result = new int[a1.length + a2.length];

        int i = 0, j = 0;
        int index = 0;

        while (index < a1.length + a2.length) {
            if (i == a1.length) {
                result[index++] = a2[j];
                j++;
                continue;
            }
            if (j == a2.length) {
                result[index++] = a1[i];
                i++;
                continue;
            }
            if (a1[i] <= a2[j]) {
                result[index++] = a1[i];
                i++;
            } else if (a1[i] > a2[j]) {
                result[index++] = a2[j];
                j++;
            }
        }

        System.out.println(Arrays.toString(result));
    }

}
