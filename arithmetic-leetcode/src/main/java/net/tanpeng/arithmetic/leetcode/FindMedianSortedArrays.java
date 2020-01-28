package net.tanpeng.arithmetic.leetcode;

/**
 * Created by peng.tan on 2020/1/28.
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int targetIndex;
        boolean flag;
        if ((nums1.length + nums2.length) % 2 != 0) {
            targetIndex = (nums1.length + nums2.length) / 2 + 1;
            flag = true;
        } else {
            targetIndex = (nums1.length + nums2.length) / 2;
            flag = false;
        }
        int i, j;
        int index = 1;
        int[] result = new int[2];
        boolean fl = false;
        for (i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] <= nums2[j]) {
                if (targetIndex == index && flag) {
                    return nums1[i];
                }
                if (fl && !flag) {
                    result[1] = nums1[i];
                    return (result[0] + result[1]) / 2.0;
                }
                if (targetIndex == index && !flag) {
                    result[0] = nums1[i];
                    fl = true;
                }
                i++;
            } else {
                if (targetIndex == index && flag) {
                    return nums2[j];
                }
                if (fl && !flag) {
                    result[1] = nums2[j];
                    return (result[0] + result[1]) / 2.0;
                }
                if (targetIndex == index && !flag) {
                    result[0] = nums2[j];
                    fl = true;
                }
                j++;
            }
            index++;
        }
        while (j < nums2.length) {
            if (targetIndex == index && flag) {
                return nums2[j];
            }
            if (fl && !flag) {
                result[1] = nums2[j];
                return (result[0] + result[1]) / 2.0;
            }
            if (targetIndex == index && !flag) {
                result[0] = nums2[j];
                fl = true;
            }
            j++;
            index++;
        }

        while (i < nums1.length) {
            if (targetIndex == index && flag) {
                return nums1[i];
            }
            if (fl && !flag) {
                result[1] = nums1[i];
                return (result[0] + result[1]) / 2.0;
            }
            if (targetIndex == index && !flag) {
                result[0] = nums1[i];
                fl = true;
            }
            i++;
            index++;
        }

        return (result[0] + result[1]) / 2.0;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{1, 1};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

}
