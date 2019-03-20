package net.tanpeng.concurrent.util;

import java.util.concurrent.CountDownLatch;

/**
 * Created by peng.tan on 2019/3/19.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程 " + Thread.currentThread() + "正在执行");
                    Thread.sleep(2000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程 " + Thread.currentThread() + "正在执行");
                    Thread.sleep(2000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("等待两个线程执行完毕");
        latch.await();
        System.out.println("两个线程执行完毕");
        System.out.println("继续执行主线程");
    }
}
