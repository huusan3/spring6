package com.yb.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUserDao
 * Package: com.yb.spring6.iocxml.bean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 10:29
 * @Version
 */
public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据类型获取接口对应bean
//        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);//这样写，根据实现类肯定能得到bean；这里要测试的是根据接口能否得到
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
