package net.tanpeng.arithmetic.singleton;

/**
 * 单例：饿汉模式，就是非懒加载，上来就加载好
 *
 * @author: peng.tan
 * @create: 2020/11/08 11:38
 */
public class Singleton4 {

    private static Singleton4 singleton4 = new Singleton4();

    private Singleton4() {

    }

    public static Singleton4 getSingleton4() {
        return singleton4;
    }
}
