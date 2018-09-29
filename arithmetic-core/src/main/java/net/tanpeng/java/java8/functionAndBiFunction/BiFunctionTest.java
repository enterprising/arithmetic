package net.tanpeng.java.java8.functionAndBiFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Function只能接受一个正常的参数（测试里面那个数字a），BiFunction主要是为了加多个参数的
 * Created by peng.tan on 2018/9/29.
 */
public class BiFunctionTest {

    public static int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    /**
     * andThen 将BiFunction返回的结果作为Function的参数，得出一个结果
     *
     * @param a
     * @param b
     * @param biFunction
     * @param function
     * @return
     */
    public static int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }

    /**
     * 为什么BiFunction没有compose方法呢？
     * 因为：如果有compose方法的话，那就是先执行Function的apply方法，
     * 但是执行完毕后只返回一个参数，而BiFunction需要两个参数，所以肯定是不行的。
     *
     * @param args
     */

    public static void main(String[] args) {
        compute3(2, 3, (v1, v2) -> v1 + v2); //5
        compute3(2, 3, (v1, v2) -> v1 - v2); //-1
        compute3(2, 3, (v1, v2) -> v1 * v2); //6

        compute4(2, 3, (v1, v2) -> v1 + v2, v1 -> v1 * v1);  //25
    }
}
