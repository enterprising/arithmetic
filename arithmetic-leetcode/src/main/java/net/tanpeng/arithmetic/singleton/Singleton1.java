package net.tanpeng.arithmetic.singleton;

/**
 * 单例：懒汉模式，懒加载，线程不安全
 * 最简单的一种
 * <p>
 * 优点：需要时才加载，无锁，很快
 * 缺点：线程不安全
 * <p>
 * 为什么线程不安全
 * 假设有两个线程，线程1、线程2 。当线程1跑到if(singleton1==null)里面但却没有执行new Singleton1 的时候，
 * singleton1 还是null，这时候线程2可能也进来了。这时候可能就创建了两个 Singleton1 的对象。
 *
 * @author: peng.tan
 * @create: 2020/11/08 10:26
 */
public class Singleton1 {

    private static Singleton1 singleton1 = null;

    // 私有化构造方法，防止通过new创建，从而破坏了单例性
    private Singleton1() {

    }

    public Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

}
