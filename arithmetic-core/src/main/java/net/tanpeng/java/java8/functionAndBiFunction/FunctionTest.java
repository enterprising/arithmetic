package net.tanpeng.java.java8.functionAndBiFunction;

import java.util.function.Function;

/**
 * 主要就 apply,compose,andThen
 * Created by peng.tan on 2018/9/29.
 */
public class FunctionTest {

    public static int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    /**
     * compose方法是一个默认方法，这个方法接收一个function作为参数，
     * 将参数function执行的结果作为参数给调用的function，以此来实现两个function组合的功能。
     * （先右再左）
     *
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    public static int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        /**
         * return (V v) -> apply(before.apply(v))
         *
         * 返回的是一个Function，输入一个参数，返回一个参数值，
         * 这个Function 在调用apply时首先执行的是 before.apply(v)
         * before在这里就是value -> value * value，也就是 2*2，将得到的结果4，
         * 作为参数传递给function1，在这里就是value -> value * 3 ，所以结果是：12
         */
        return function1.compose(function2).apply(a);
    }

    /**
     * 先左再右
     *
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    public static int compute3(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    public static void main(String[] args) {
        /**
         * 可以看到我们定义一个方法就可以实现多种功能，这就是前面说过的Lambda表达式传递的是一种行为，
         * 我们把想要做的事在调用的时候，以一种行为的方式传递进来，程序读起来也更加直观
         */
        compute(5, value -> value * value); //25 计算平方
        compute(5, value -> value + value); //10 求和
        compute(5, value -> value - 2); //3

        compute2(2, value -> value * 3, value -> value * value);  //12

        compute3(2, value -> value * 3, value -> value * value);  //36
    }
}
