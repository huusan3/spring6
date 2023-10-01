package com.yb;

import com.yb.bean.AnnotationApplicationContext;
import com.yb.bean.ApplicationContext;
import com.yb.service.UserService;

/**
 * ClassName: TestUser
 * Package: com.yb
 * Description:
 *
 * @Author yang
 * @Create 2023/7/3 11:25
 * @Version
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.yb");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
