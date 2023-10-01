package com.yb.spring6.iocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName: MyFactoryBean
 * Package: com.yb.spring6.iocxml.factorybean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/21 16:22
 * @Version
 */
public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
