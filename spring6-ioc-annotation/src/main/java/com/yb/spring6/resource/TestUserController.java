package com.yb.spring6.resource;

import com.yb.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUserController
 * Package: com.yb.spring6.autowired
 * Description:
 *
 * @Author yang
 * @Create 2023/6/25 13:43
 * @Version
 */
public class TestUserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean("myUserController", UserController.class);
        controller.add();
    }
}
