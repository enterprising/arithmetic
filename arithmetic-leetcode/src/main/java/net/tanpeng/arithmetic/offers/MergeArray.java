package net.tanpeng.arithmetic.offers;

public class MergeArray {
    public static void merge(int[] A, int m, int[] B, int n) {
        int indexA = A.length - 1;
        while (indexA >= 0) {
            if (m == 0) {
                A[indexA] = B[n - 1];
                n--;
            } else if (n == 0) {
                A[indexA] = A[m - 1];
                m--;
            } else if (A[m - 1] >= B[n - 1]) {
                A[indexA] = A[m - 1];
                m--;
            } else {
                A[indexA] = B[n - 1];
                n--;
            }
            indexA--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 0};
        int m = 1;
        int[] B = new int[]{2};
        int n = 1;
        merge(A, m, B, n);
//        int[] A = new int[]{1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] B = new int[]{2, 5, 6};
//        int n = 3;
//        merge(A, m, B, n);
    }
}
