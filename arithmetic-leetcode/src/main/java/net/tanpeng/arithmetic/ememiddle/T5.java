package net.tanpeng.arithmetic.ememiddle;

/**
 * 5. 对一个整数开根号(不许用库函数)
 * 点评: 方法应该有很多。这道题目还是为某些有机器学习背景的同学准备的。我本人是比较倾向于候选人用牛顿迭代法来做，
 * 如果接触过一些机器学习或者上过类似计算方法这样的课程，应该是第一时间反应用牛顿迭代法。
 * <p>
 * 放弃
 * Created by peng.tan on 2019/4/23.
 */
public class T5 {
    public static void main(String[] args) {
        System.out.println(normal5(9));
    }

    public static float normal5(int m) {
        // 牛顿迭代法，求解x^2-a=0
        // y=f(x)'(x-x0) + f(x0)
        // m=2x0(x1-x0)+x0^2 --> m=2x0*x1-x0^2 --> x1=(m+x0^2)/2x0
        if (m <= 1) {
            return m;
        }
        float err = 0.001f;
        int maxIter = 100;
        float currErr = m;
        int i = 0;
        float curr = 1;
        float next = 0;
        while (i < maxIter && currErr > err) {
            next = (m + curr * curr) / 2 / curr;
            currErr = Math.abs(next * next - m);
            curr = next;
            i++;
        }
        return next;
    }
}
