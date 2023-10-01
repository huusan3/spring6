package com.yb.spring6.aop.example;

/**
 * ClassName: TestCalculator
 * Package: com.yb.spring6.aop.example
 * Description:
 *
 * @Author yang
 * @Create 2023/7/5 11:01
 * @Version
 */
public class TestCalculator {
    public static void main(String[] args) {
        // 1 创建代理对象（动态方式）
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,3);
        proxy.mul(6,7);
    }
}
