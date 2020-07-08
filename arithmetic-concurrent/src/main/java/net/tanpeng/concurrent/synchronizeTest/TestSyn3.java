package net.tanpeng.concurrent.synchronizeTest;

/**
 * 使用同一个对象启动不同线程，这时候就 OK 了
 *
 * @author: peng.tan
 * @create: 2020/07/08 22:45
 */
public class TestSyn3 implements Runnable {
    public static final Object lockHelper = new Object();

    static int count = 0;

    public synchronized void increase() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        TestSyn3 ts = new TestSyn3();
        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
