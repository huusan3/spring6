package com.yb.spring6.iocxml.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestEmp
 * Package: com.yb.spring6.iocxml.di1
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 9:19
 * @Version
 */
public class TestEmp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di1-2.xml");
        //员工对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();
    }
}
