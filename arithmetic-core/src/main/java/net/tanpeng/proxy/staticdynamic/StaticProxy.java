package net.tanpeng.proxy.staticdynamic;

/**
 * 静态代理
 * https://www.jianshu.com/p/af8b6451b712
 * Created by peng.tan on 2019/4/16.
 */
public class StaticProxy {

    // 目的是在计算前后输出 before 和 after
    // 用静态代理的话，需要实现接口，然后重写接口方法
    public static void main(String[] args) {
        Calculator calc = new CalcProxy();
        calc.add(7, 6);
    }

    static class CalcProxy implements Calculator {
        private Calculator calculator;

        public CalcProxy() {
            calculator = new CalculatorImpl();
        }

        @Override
        public void add(Integer x, Integer y) {
            before();
            calculator.add(x, y);
            after();
        }


        @Override
        public void div(Integer x, Integer y) {
            before();
            calculator.div(x, y);
            after();
        }

        private void before() {
            System.out.println("before");
        }

        private void after() {
            System.out.println("after");
        }
    }
}

