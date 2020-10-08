package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/10/07 12:00
 */
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        int result = 0;
        int low = 0;
        int hight = array.length;
        int mid;
        while (low < hight) {
            mid = low + (hight - low) / 2;
            if (array[mid] > k) {
                hight = mid - 1;
            }
            if (array[mid] < k) {
                low = mid + 1;
            }
            if (array[mid] == k) {
                // 往前往后遍历
                int index = mid;
                while (index >= 0 && array[index] == k) {
                    index--;
                    result++;
                }
                index = mid + 1;
                while (index <= hight - 1 && array[index] == k) {
                    index++;
                    result++;
                }
                return result;
            }
        }
        return result;
    }

}
