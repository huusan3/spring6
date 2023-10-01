package com.yb.spring6.iocxml.bean;

/**
 * ClassName: PersonDaoImpl
 * Package: com.yb.spring6.iocxml.bean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 10:43
 * @Version
 */
public class PersonDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("person run...");
    }
}
