package com.yb.spring6.aop.annoaop;

import org.springframework.stereotype.Component;

/**
 * ClassName: CalculatorImpl
 * Package: com.yb.spring6.aop.example
 * Description:
 *
 * @Author yang
 * @Create 2023/7/3 16:06
 * @Version
 */
//基本实现类
    @Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
//        //测试异常通知
//        int a = 1 / 0;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
