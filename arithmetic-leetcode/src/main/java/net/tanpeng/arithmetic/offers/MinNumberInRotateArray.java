package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/05/03 21:48
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        // 二分
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                // 当和最右边相等时，你不知道是不是最小的，比如 [1,0,1,1,1] 或者[1,1,1,0,1]，
                // 这时候只能一个个的试
                high = high - 1;
            } else {
                // 这里不能high = mid - 1; 如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
                /**
                 * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
                 * 如果high = mid - 1，就会产生错误， 因此high = mid
                 * 但情形(1)中low = mid + 1就不会错误
                 */
                high = mid;
            }
        }
        return array[low];
    }
}
