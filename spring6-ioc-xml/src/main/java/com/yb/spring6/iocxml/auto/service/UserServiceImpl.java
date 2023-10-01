package com.yb.spring6.iocxml.auto.service;

import com.yb.spring6.iocxml.auto.dao.UserDao;
import com.yb.spring6.iocxml.auto.dao.UserDaoImpl;

/**
 * ClassName: UserServiceImpl
 * Package: com.yb.spring6.iocxml.auto.service
 * Description:
 *
 * @Author yang
 * @Create 2023/6/23 18:00
 * @Version
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService 方法执行了...");
        //调用userDao的方法
        userDao.addUserDao();
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }
}
