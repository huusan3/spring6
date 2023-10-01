package com.yb.spring6.iocxml.bean;

/**
 * ClassName: UserDaoImpl
 * Package: com.yb.spring6.iocxml.bean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 10:23
 * @Version
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("run...");
    }
}
