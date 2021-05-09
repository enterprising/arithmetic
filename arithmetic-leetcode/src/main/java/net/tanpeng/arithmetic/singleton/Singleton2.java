package net.tanpeng.arithmetic.singleton;

/**
 * 单例：懒汉模式，线程安全
 * <p>
 * 优点：解决了前面的两个线程同时创建的问题，保证了线程安全
 * 缺点：之后每次拿都需要进入锁里面，很耗性能。虽然之后里面直接return，但是拿锁是个很耗资源的操作
 *
 * @author: peng.tan
 * @create: 2020/11/08 10:33
 */
public class Singleton2 {
    private static Singleton2 singleton2 = null;

    private Singleton2() {

    }

    public synchronized static Singleton2 getSingleton2() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }

        return singleton2;
    }
}
