package com.yb.spring6.iocxml.auto;

import com.yb.spring6.iocxml.auto.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.image.renderable.ContextualRenderedImageFactory;

/**
 * ClassName: TestUser
 * Package: com.yb.spring6.iocxml.auto
 * Description:
 *
 * @Author yang
 * @Create 2023/6/24 20:45
 * @Version
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController controller = context.getBean("userController", UserController.class);
        controller.addUser();

    }
}
