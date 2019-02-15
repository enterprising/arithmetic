package net.tanpeng.arithmetic.offers;

/**
 * Created by peng.tan on 2019/1/12.
 */
public class Solution1 {
    public static boolean Find(int target, int[][] array) {
        int mid = array[0].length / 2;
        int left = 0;
        int right = array[0].length - 1;
        while (left < right) {
            if (array[0][mid] > target) {
                right = mid-1;
                mid = (mid - left) / 2;
            } else if (array[0][mid] < target) {
                left = mid+1;
                mid = (right - mid) / 2;
            } else {
                return true;
            }
        }
        int yLeft = 0;
        int yRight = array.length - 1;
        int yMid = array.length / 2;
        while (yLeft < yRight) {
            if (array[yMid][mid] > target) {
                yRight = yMid-1;
                yMid = (yMid - yLeft) / 2;
            } else if (array[yMid][mid] < target) {
                yLeft = yMid+1;
                yMid = (yRight - yMid) / 2;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Find(5,map));
        System.out.println();
    }
}
