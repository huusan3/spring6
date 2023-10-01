package com.yb.spring6.iocxml.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUser
 * Package: com.yb.spring6.iocxml.factorybean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/21 16:25
 * @Version
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User user = (User)context.getBean("user");
        System.out.println(user);
    }
}
