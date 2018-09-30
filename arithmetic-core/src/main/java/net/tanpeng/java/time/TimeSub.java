package net.tanpeng.java.time;

import java.time.Duration;
import java.time.Instant;

/**
 * 求时间差的两种方式：1、instance and duration ; 2、System.currentTimeMillis();
 * Created by peng.tan on 2018/9/30.
 */
public class TimeSub {
    /**
     * 根据Java8最新的时间api来计算
     */
    private static void methoid1() {
        Instant start = Instant.now();
        // do something
        Instant end = Instant.now();
        Duration duration = Duration.between(end, start);
        System.out.println(duration);
    }

    /**
     * 根据系统毫秒数来判断目标代码块执行的时间长度
     */
    private static void method2() {
        Long now = System.currentTimeMillis();
        // do something
        Long end = System.currentTimeMillis();
        System.out.println(end - now);
    }
}
