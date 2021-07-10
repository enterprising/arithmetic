package com.jvm.jvmParamTest;

/**
 * -Xss 为jvm启动的每个线程分配的内存大小，默认JDK1.4中是256K，JDK1.5+中是1M
 * 根据应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。
 * 但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。
 *
 * @author: peng.tan
 * @create: 2020/07/06 23:40
 */
public class TestXss {
    private static long count = 0;

    public static void main(String[] args) {
        infinitelyRecursiveMethod(1);

    }

    public static void infinitelyRecursiveMethod(long a) {
        // 注意，这里只是调用次数，输出的值不少 -Xss 的值， -Xss 是内存大小
        System.out.println(count++);
        infinitelyRecursiveMethod(a);
    }

}
