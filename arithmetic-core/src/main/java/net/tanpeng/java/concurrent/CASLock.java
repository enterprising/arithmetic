package net.tanpeng.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peng.tan on 2018/2/12.
 * CAS(compare and swap) 比较并替换 (乐观锁)
 * 原理：比较并替换，只要内存值和期望值相同，将内存值更新为需要的值
 */
public class CASLock {

    // CountDownLatch一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
    private static final CountDownLatch LATCH = new CountDownLatch(5);

    // Atomic内部通过CAS实现原子操作，这句话是重点，可以看getAndIncrement的实现
    private static AtomicInteger i = new AtomicInteger(0);
    private static int p = 0;

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 5; j++) {
            pool.execute(() -> {
                for (int k = 0; k < 10000; k++) {
                    p++;  //不是原子操作
                    i.getAndIncrement(); //调用原子类加1
                }
                LATCH.countDown();
            });
        }
        LATCH.await(); //保证所有子线程执行完成
        System.out.println(System.currentTimeMillis() - time);
        System.out.println("p=" + p);
        System.out.println("i=" + i);
        pool.shutdown();

    }

}
