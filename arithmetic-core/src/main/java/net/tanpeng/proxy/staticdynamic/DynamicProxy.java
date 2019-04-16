package net.tanpeng.proxy.staticdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 静态代理可以解决问题，为啥需要动态代理呢？
 * 原因在于一个静态代理只能代理一个接口，这样就导致项目中到处都是 xxxproxy
 * 这里把DynamicProxy当做了Calculator的代理，改掉了Calculator的行为。
 * <p>
 * Created by peng.tan on 2019/4/16.
 */
public class DynamicProxy implements InvocationHandler {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(calculator);
        Calculator calc = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), dynamicProxy);
        calc.add(7, 6);
    }

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}