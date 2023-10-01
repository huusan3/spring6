package com.yb.spring6.iocxml.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestDept
 * Package: com.yb.spring6.iocxml.di1
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 11:24
 * @Version
 */
public class TestDept {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di1-3.xml");
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }
}
