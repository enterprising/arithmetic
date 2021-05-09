package net.tanpeng.arithmetic.singleton;

/**
 * 懒汉模式，双重检查，线程安全
 * 优点：懒加载且线程安全，缺点 无
 * <p>
 * 1、为什么需要双重检查？（注意是双重检查，不是双重加锁，锁只有一个）
 * 因为两个线程进来，第一个创建好之后退出锁，第二个再拿到锁，不可能再创建一个
 * <p>
 * 2、为什么需要 volatile？
 * 创建对象分成四步，1、申请内存地址，2、赋初始值，3、构造方法，4、把引用和实例关联起来
 * 因为有个指令重排的概念，意思是单线程里面，只要最终结果一样，就有几率jvm自己优化重排指令。比如1234会变成1243，
 * 只要是1243，在多线程里面，第二个线程进来，会发现在最外层singleton3DoubleCheck不是null，但是其实构造方法没结束，返回的不是一个完整的单例对象
 *
 * @author: peng.tan
 * @create: 2020/11/08 10:53
 */
public class Singleton3DoubleCheck {
    private static volatile Singleton3DoubleCheck singleton3DoubleCheck = null;

    private Singleton3DoubleCheck() {

    }

    public static Singleton3DoubleCheck getSingleton3DoubleCheck() {
        if (singleton3DoubleCheck == null) {
            synchronized (Singleton3DoubleCheck.class) {
                if (singleton3DoubleCheck == null) {
                    singleton3DoubleCheck = new Singleton3DoubleCheck();
                }
            }
        }
        return singleton3DoubleCheck;
    }

}
