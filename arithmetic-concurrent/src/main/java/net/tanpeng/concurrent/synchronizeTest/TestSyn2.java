package net.tanpeng.concurrent.synchronizeTest;

/**
 * 此处已加锁，但本地运行结果为：15317(每次运行结果不同，但都是小于20000)，说明没有锁住。
 * 分析代码，syn修饰实例方法，锁住的是对象，但是启动线程时是新new的对象，
 * 这也就意味着存在着两个不同的实例对象锁，导致两个线程都拿到了各自的锁，同时进入了increase方法，无法保证线程安全
 *
 * @author: peng.tan
 * @create: 2020/07/08 22:39
 */
public class TestSyn2 implements Runnable {
    public static final Object lockHelper = new Object();

    static int count = 0;

    public synchronized void increase() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TestSyn2());
        Thread t2 = new Thread(new TestSyn2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}