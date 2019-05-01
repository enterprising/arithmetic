package net.tanpeng.arithmetic.ememiddle;

/**
 * 9. 10进制数转成16进制(不许用库函数，不许用)， given 100, return 64, given 250, return FA
 * 简化一下，只考虑正数，负数的十六进制表达有点怪怪的。
 * 点评: 就是各种基本功了，也没啥，力求代码写得好看点。
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T9 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int m = 100;
        m = Math.abs(m);
        while (m > 0) {
            sb.append(chars[m % 16]);
            m = m / 16;
        }
        System.out.println(sb.reverse().toString());
    }

}
