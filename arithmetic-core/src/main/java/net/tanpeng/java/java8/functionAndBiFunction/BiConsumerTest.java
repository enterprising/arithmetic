package net.tanpeng.java.java8.functionAndBiFunction;

import java.util.function.BiConsumer;

/**
 * Created by peng.tan on 2019/5/21.
 */
public class BiConsumerTest {
    public static void main2(String[] args) {
        BiConsumer<Integer, Integer> biConsumer = (key, value) -> {
            System.out.println(key + value);
        };

        biConsumer.accept(1, 1);
        // 用途的话是往方法里面传参数
    }

    public static void main(String[] args) {
        BiConsumer<Integer, Integer> addition = (a, b) -> {
            System.out.println(a + b);
        };
        BiConsumer<Integer, Integer> subtraction = (a, b) -> {
            System.out.println(a - b);
        };
        addition.andThen(subtraction).accept(2, 1);
    }

}