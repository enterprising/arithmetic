package net.tanpeng.arithmetic.ememiddle;

/**
 * 7. 判断一个字符串是不是合法的ip(不许用正则)
 * 点评: 考察字符串基本操作，各种边界条件。要想写个bugfree的没有那么简单。
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T7 {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        if (ip.length() < 7 || ip.length() > 15) {
            System.out.println("不符合");
            return;
        }

        String[] x = ip.split("\\.");
        for (String item : x) {
            if (Integer.parseInt(item) > 255 || Integer.parseInt(item) < 0) {
                System.out.println("不符合");
                return;
            }
        }
        System.out.println("符合");
    }
}
