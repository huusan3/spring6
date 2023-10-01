package com.yb.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUser
 * Package: com.yb.spring6
 * Description:
 *
 * @Author yang
 * @Create 2023/6/13 16:43
 * @Version
 */
public class TestUser {
    //创建Logger对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    //通过spring完成对象创建及方法调用
    @Test
    public void testUserObject(){
        //加载spring的配置文件，进行对象的创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取创建的对象（获取bean）
        User user = (User)context.getBean("user");
        System.out.println("1:" + user);//输出user对象的地址
        //使用对象调用方法进行测试
        System.out.print("2:");
        user.add();

        //手动写入日志
        logger.info("### 执行调用成功了...");
    }

    //反射创建对象
    @Test
    public void testUserObject1() throws Exception {
        //获取类的字节码文件
        Class clazz = Class.forName("com.yb.spring6.User");
        //调用方法创建对象
//        Object o = clazz.newInstance();
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
