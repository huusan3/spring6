package com.yb.spring6.autowired.service;

import com.yb.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.yb.spring6.autowired.service
 * Description:
 *
 * @Author yang
 * @Create 2023/6/25 13:10
 * @Version
 */
@Service
public class UserServiceImpl implements UserService{
    //注入dao
//    //方式1：属性注入
//    @Autowired  //根据类型找到对应对象，完成注入
//    private UserDao userDao;

//    //方式2：set方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    //方式3：构造方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    //方式4：形参上注入
//    private UserDao userDao;
//
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    //方式5：使用两个注解，根据名称进行注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
