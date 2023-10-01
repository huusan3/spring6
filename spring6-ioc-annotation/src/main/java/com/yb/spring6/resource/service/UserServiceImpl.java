package com.yb.spring6.resource.service;

import com.yb.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
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
@Service(value = "myUserService")
public class UserServiceImpl implements UserService {
    //注入dao
    //不指定名称，根据属性名称进行注入
    @Resource
    private UserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service...");
        myUserDao.add();
    }
}
