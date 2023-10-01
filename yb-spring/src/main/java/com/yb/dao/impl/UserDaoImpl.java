package com.yb.dao.impl;

import com.yb.annotation.Bean;
import com.yb.dao.UserDao;

/**
 * ClassName: UserDaoImpl
 * Package: com.yb.dao.impl
 * Description:
 *
 * @Author yang
 * @Create 2023/6/28 17:31
 * @Version
 */
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao...");
    }
}
