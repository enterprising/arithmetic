package net.tanpeng.proxy.dynamicdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by peng.tan on 2019/4/16.
 */
public class Test {

    // 这里面handler本质上是个代理对象，people是真实对象，然后把这两个扔到Proxy.newProxyInstance
    // 返回一个People对象，这时候本质上people已经被代理了
    public static void main(String[] args) {
        // 要代理的真实对象
        People people = new Teacher();
        // 代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理构造参数中，
        // 最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler handler = new WorkHandler(people);

        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象
         * 第一个参数：people.getClass().getClassLoader(), 使用people对象的classloader来加载我们的代理对象
         * 第二个参数：people.getClass().getInterfaces(), 使用interfaces，为代理类提供的接口是真实对象实现的接口。这样代理对象才可以跟真实对象行为一样
         * 第三个参数：hander，我们将代理对象关联到上面的handler对象上，本质上代理封装自己的行为就是在上面那个类里面写的，这里是映射到那个
         */
        People proxy = (People) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);

        System.out.println(proxy.work());
    }
}
