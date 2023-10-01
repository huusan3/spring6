package com.yb.spring6.iocxml.auto.dao;

/**
 * ClassName: UserDaoImpl
 * Package: com.yb.spring6.iocxml.auto.dao
 * Description:
 *
 * @Author yang
 * @Create 2023/6/23 18:01
 * @Version
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void addUserDao() {
        System.out.println("userDao 方法执行了...");
    }
}
