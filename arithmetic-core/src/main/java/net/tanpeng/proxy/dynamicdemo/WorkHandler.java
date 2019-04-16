package net.tanpeng.proxy.dynamicdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义一个代理类的调用处理程序，每个代理类的调用处理程序都必须实现InvocationHandler接口
 */
public class WorkHandler implements InvocationHandler {

    // 代理类中的真实对象
    private Object object;

    public WorkHandler(Object o) {
        this.object = o;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在真实的对象执行之前添加我们自己的操作
        System.out.println("before invoke ... ");
        Object invoke = method.invoke(object, args);
        // 在真实的对象执行之后添加我们自己的操作
        System.out.println("after invoke ...");
        return invoke;
    }

}
