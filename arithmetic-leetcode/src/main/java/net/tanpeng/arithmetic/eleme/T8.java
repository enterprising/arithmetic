package net.tanpeng.arithmetic.eleme;

/**
 * 8. 给定两个区间，判断这两个区间是否重合，
 * given [1,3],[5,6] return 不重合(false), given[1,3],[2,5] return 重合(true)
 * 点评: 考察一下逻辑思维能力，没啥特别的，也就一行代码的事情。
 * Created by peng.tan on 2019/4/19.
 */
public class T8 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2, 5};

        if (a[0] < b[0] && a[1] > b[0] || a[0] > b[0] && a[0] < a[1]) {
            System.out.println("重合");
        }
    }
}
