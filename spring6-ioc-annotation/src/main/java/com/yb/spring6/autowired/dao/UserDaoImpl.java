package com.yb.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

/**
 * ClassName: UserDaoImpl
 * Package: com.yb.spring6.autowired.dao
 * Description:
 *
 * @Author yang
 * @Create 2023/6/25 13:11
 * @Version
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao...");
    }
}
