package net.tanpeng.arithmetic.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 基数排序
 * 无需比较的三排排序之一
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = new int[]{53, 42, 46, 26, 78};
        radixSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void radixSort(int[] a) {
        // 获取最大 item 的长度
        int maxBit = getMaxBit(a);
        for (int i = 1; i <= maxBit; i++) {
            List<List<Integer>> buf = distribute(a, i); // 按第 i 位进行分配
            collection(a, buf);  //将 buf 分配到 a 里面 （这时候 a 里面元素的顺序变了）
        }
    }

    private static void collection(int[] a, List<List<Integer>> buf) {
        int k = 0;
        for (List<Integer> item : buf) {
            for (int num : item) {
                a[k++] = num;
            }
        }
    }

    /**
     * @param a    待分配的数组
     * @param iBit 要分配的第 i 位
     * @return
     */
    private static List<List<Integer>> distribute(int[] a, int iBit) {
        List<List<Integer>> buf = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buf.add(new LinkedList<>());
        }
        for (int i = 0; i < a.length; i++) {
            int index = getNbit(a[i], iBit);
            buf.get(index).add(a[i]);
        }
        return buf;
    }

    /**
     * 获取 item 的第 n-iBit 位的元素
     *
     * @param item 目标数字
     * @param iBit 目标位数
     * @return
     */
    private static int getNbit(int item, int iBit) {
        String x = item + "";
        if (x.length() < iBit)
            return 0;
        return x.charAt(x.length() - iBit) - '0';  //这里有两个点，一个是：比较从最低位开始； 还一个是，- '0' 返回正常的数字
    }

    /**
     * 获取最大位数
     *
     * @param a
     * @return
     */
    private static int getMaxBit(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int item : a) {
            int length = (item + "").length();
            if (length > max)
                max = length;
        }
        return max;
    }

}
