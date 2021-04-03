package net.tanpeng.concurrent.synchronizeTest;

/**
 * https://blog.csdn.net/pengqiaowolf/article/details/80396882
 *
 * @author: peng.tan
 * @create: 2020/07/08 22:30
 */
public class TestSyn implements Runnable {
    public static final Object lockHelper = new Object();

    static int count = 0;

    public void increase() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TestSyn());
        Thread t2 = new Thread(new TestSyn());
        t1.start();
        t2.start();
        // 主线程的代码块中，如果碰到了t.join()方法，此时主线程需要等待（阻塞），
        // 等待子线程结束了(Waits for this thread to die.),才能继续执行t.join()之后的代码块。
        t1.join();
        t2.join();
        System.out.println(count);
    }
}