package net.tanpeng.arithmetic.singleton;

/**
 * 单例，静态内部类
 * 优势 懒加载，用到才加载。
 * 将懒加载和线程安全做到的完美结合，并且无锁
 * <p>
 * 原理
 * 内部类，与外部类没有绑定关系，只有当内部类被调用时才会加载，所以做到了懒加载
 * static Singleton5 singleton5 = new Singleton5(); 这个由jvm来保证原子性，线程安全
 *
 * @author: peng.tan
 * @create: 2020/11/08 11:39
 */
public class Singleton5 {

    private static class Inner {
        private static Singleton5 singleton5 = new Singleton5();
    }

    private Singleton5() {

    }

    public Singleton5 getSingleton() {
        return Inner.singleton5;
    }
}
