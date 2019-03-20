package net.tanpeng.concurrent.util;

import java.util.concurrent.CyclicBarrier;

/**
 * 字面意思是循环栅栏，通过它可以实现一组线程等待至某个状态之后再全部执行。
 * 之所以叫做循环，是因为当所有的等待线程都被释放之后，CyclicBarrier可以被重用。
 * 当调用await()方法之后，线程就处于barrier了。
 */
public class CyclicBarrierTest {
    // 典型的场景，实现读写锁。所有的读操作都等到写操作完成之后
    public static void main(String[] args) {
        int n = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);

        for (int i = 0; i < n; i++) {
            new WriterClass(cyclicBarrier).start();
        }
    }

    private static class WriterClass extends Thread {
        private CyclicBarrier cyclicBarrier;

        WriterClass(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
