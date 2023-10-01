package com.yb.spring6.iocxml.auto.controller;

import com.yb.spring6.iocxml.auto.service.UserService;
import com.yb.spring6.iocxml.auto.service.UserServiceImpl;

/**
 * ClassName: UserController
 * Package: com.yb.spring6.iocxml.auto
 * Description:
 *
 * @Author yang
 * @Create 2023/6/23 17:59
 * @Version
 */
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller 方法执行了...");
        //调用service的方法
        userService.addUserService();
//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}
