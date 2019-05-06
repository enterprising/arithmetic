package wechart.util;

/**
 * Created by peng.tan on 2019/5/6.
 */
public class Util {
    public static long getHashCode(String id) {
        if (id == null)
            return -1;

        char[] value = id.toCharArray();
        long h = 0;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
        }
        h = Math.abs(h);
        h = h % 1024;
        return h;
    }

    public static void main(String[] args) {
        System.out.println(getHashCode("123123123"));
        System.out.println(123123123 & 1023);
    }
}
