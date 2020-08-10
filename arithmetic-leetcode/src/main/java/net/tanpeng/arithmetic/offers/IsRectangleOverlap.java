package net.tanpeng.arithmetic.offers;

public class IsRectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x11 = rec2[0];
        int y11 = rec2[1];
        int x22 = rec2[2];
        int y22 = rec2[3];

        // 左
        if (x1 >= x22) {
            return false;
        }
        // 右
        if (x2 <= x11) {
            return false;
        }
        // 上
        if (y2 <= y11) {
            return false;
        }
        // 下
        if (y1 >= y22) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 8, 4, 14};
        int[] b = new int[]{14, 15, 15, 17};
        isRectangleOverlap(a, b);
    }
}
