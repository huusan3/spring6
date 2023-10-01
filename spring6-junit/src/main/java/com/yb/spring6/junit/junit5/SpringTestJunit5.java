package com.yb.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: SpringTestJunit5
 * Package: com.yb.spring6.junit.junit5
 * Description:
 *
 * @Author yang
 * @Create 2023/7/17 11:39
 * @Version
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit5 {
    //注入
    @Autowired
    private User user;

    //测试方法
    @Test
    public void test(){
        System.out.println(user);
        user.run();
    }
}
