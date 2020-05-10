package net.tanpeng.arithmetic.offers;

/**
 * @author: peng.tan
 * @create: 2020/05/05 12:48
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootval = sequence[end];
        // 找到小于的那一堆
        int leftEnd = start;
        for (int i = start; i < end && sequence[i] < rootval; i++) {
            leftEnd++;
        }
        // 这时候leftEnd是下一个的开始
        for (int j = leftEnd; j < end; j++) {
            if (sequence[j] < rootval) {
                return false;
            }
        }
        boolean left = helper(sequence, start, leftEnd - 1);
        boolean right = helper(sequence, leftEnd, end - 1);
        return left && right;
    }
}
