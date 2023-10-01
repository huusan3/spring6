package com.yb.spring6.resource;

import com.yb.spring6.config.SpringConfig;
import com.yb.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUserControllerAnno
 * Package: com.yb.spring6.resource
 * Description:
 *
 * @Author yang
 * @Create 2023/6/27 17:00
 * @Version
 */
public class TestUserControllerAnno {
    public static void main(String[] args) {
        //加载配置类进行实现
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }


}
