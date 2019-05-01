package net.tanpeng.arithmetic.ememiddle;

import java.util.Random;

/**
 * 4. 求pi，没错就是求pi(圆周率)。
 * 点评: 如果候选人有机器学习相关背景，并且对于蒙特卡罗方法比较熟悉的话，应该可以写出来。
 * <p>
 * <p>
 * 这题放弃
 * Created by peng.tan on 2019/4/23.
 */
public class T4 {

    public static void main(String[] args) {
        System.out.println(normal4());
    }

    public static float normal4() {
        Random r = new Random();
        int total = 10000000;
        int sum = 0;
        for (int i = 0; i < total; i++) {
            //随机生成[0,1]之间的坐标点
            double distance = Math.pow(r.nextFloat(), 2) + Math.pow(r.nextFloat(), 2);
            if (distance <= 1) {
                sum++;
            }
        }
        return (float) sum * 4 / total;
    }
}
