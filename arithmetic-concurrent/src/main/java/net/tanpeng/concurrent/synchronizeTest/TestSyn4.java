package net.tanpeng.concurrent.synchronizeTest;

/**
 * 运行结果为20000，证明锁生效。此处虽然与1的失败demo大体一样，但是成功，
 * 是因为syn修饰的是静态方法，锁的是类对象，虽然有两个不同实体，但是是同一个类对象，保证线程安全。
 *
 * @author: peng.tan
 * @create: 2020/07/08 22:47
 */
public class TestSyn4 implements Runnable {
    public static final Object lockHelper = new Object();

    static int count = 0;

    public synchronized static void increase() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TestSyn4());
        Thread t2 = new Thread(new TestSyn4());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}