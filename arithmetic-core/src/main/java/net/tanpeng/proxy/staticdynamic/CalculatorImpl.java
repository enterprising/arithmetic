package net.tanpeng.proxy.staticdynamic;

/**
 * Created by peng.tan on 2019/4/16.
 */
class CalculatorImpl implements Calculator {
    @Override
    public void add(Integer x, Integer y) {
        System.out.println(x + y);
    }
    @Override
    public void div(Integer x, Integer y) {
        System.out.println(x - y);
    }
}
