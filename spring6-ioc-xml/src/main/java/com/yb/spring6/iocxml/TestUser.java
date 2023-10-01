package com.yb.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUser
 * Package: com.yb.spring6.iocxml
 * Description:
 *
 * @Author yang
 * @Create 2023/6/18 12:28
 * @Version
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");//配置文件的路径名称
        //获取bean（即，获取对象）
        //1.根据id获取bean
        User user1 = (User)context.getBean("user");
        System.out.println("1 根据id获取bean:" + user1);
        //2.根据类型获取bean
        User user2 = context.getBean(User.class);
        System.out.println("2 根据类型获取bean:" + user2);
        //3.根据id和类型获取bean
        User user3 = context.getBean("user", User.class);
        System.out.println("3 根据id和类型获取bean：" + user3);
    }
}
