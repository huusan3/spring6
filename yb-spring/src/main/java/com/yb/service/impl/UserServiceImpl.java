package com.yb.service.impl;

import com.yb.annotation.Bean;
import com.yb.annotation.Di;
import com.yb.dao.UserDao;
import com.yb.service.UserService;

/**
 * ClassName: UserServiceImpl
 * Package: com.yb.service.impl
 * Description:
 *
 * @Author yang
 * @Create 2023/6/28 17:30
 * @Version
 */
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        //调用dao的方法
        userDao.add();

    }
}
