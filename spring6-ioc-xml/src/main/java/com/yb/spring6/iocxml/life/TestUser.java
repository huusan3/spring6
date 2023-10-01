package com.yb.spring6.iocxml.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUser
 * Package: com.yb.spring6.iocxml.life
 * Description:
 *
 * @Author yang
 * @Create 2023/6/21 15:49
 * @Version
 */
public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6 bean对象创建完成...");
        System.out.println(user);
        context.close(); //对bean进行销毁
    }
}
