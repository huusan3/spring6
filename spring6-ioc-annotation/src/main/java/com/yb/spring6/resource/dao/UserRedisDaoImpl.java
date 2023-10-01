package com.yb.spring6.resource.dao;

import org.springframework.stereotype.Repository;

/**
 * ClassName: UserRedisDaoImpl
 * Package: com.yb.spring6.autowired.dao
 * Description:
 *
 * @Author yang
 * @Create 2023/6/25 15:20
 * @Version
 */
@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("daoredis...");
    }
}
