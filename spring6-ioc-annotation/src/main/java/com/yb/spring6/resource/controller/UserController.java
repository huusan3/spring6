package com.yb.spring6.resource.controller;

import com.yb.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * ClassName: UserController
 * Package: com.yb.spring6.autowired.controller
 * Description:
 *
 * @Author yang
 * @Create 2023/6/25 13:09
 * @Version
 */
@Controller("myUserController")
public class UserController {
    //注入service
    //根据名称进行注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    //根据类型进行匹配
    @Resource
    private UserService userService;

    public void add(){
        System.out.println("controller...");
        userService.add();
    }
}
