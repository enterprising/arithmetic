package net.tanpeng.arithmetic.eleme;

/**
 * 5. 输入两个字符串表示version，"1.1.2", "1.1.1", 判断两个version那个是最新的。(简化一下，假定输入都是合法的)
 * "1.1.1" < "1.1.2"。 "2" > "1.1"
 * Created by peng.tan on 2019/4/18.
 */
public class T5 {
    public static void main(String[] args) {
        String version1 = "1.1.1";
        String version2 = "1.2";

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < v1.length; i++) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                System.out.println("v1 新");
                break;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                System.out.println("v2 新");
                break;
            }
        }
    }
}
