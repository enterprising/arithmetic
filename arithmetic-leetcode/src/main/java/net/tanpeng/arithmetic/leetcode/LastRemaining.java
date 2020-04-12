package net.tanpeng.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 完成
 *
 * @author: peng.tan
 * @create: 2020/03/30 22:57
 */
public class LastRemaining {

    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            // 计算当前需要移除的下标
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }


    /**
     * 能做，但是会超时
     */
    public static int lastRemaining2(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 1;
        int temp = 0;
        while (list.size() != 1) {
            if (index == m) {
                list.remove(temp);
                index = 1;
                continue;
            }
            if (temp == list.size()) {
                temp = 0;
            }
            temp = temp + 1 >= list.size() ? 0 : temp + 1;
            index = index + 1;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        // 0、1、2、3、4
        lastRemaining(5, 3);
    }
}
