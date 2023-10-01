package com.yb.spring6.junit.junit4;

import com.yb.spring6.junit.junit5.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * ClassName: SpringTestJunit4
 * Package: com.yb.spring6.junit.junit4
 * Description:
 *
 * @Author yang
 * @Create 2023/7/17 15:29
 * @Version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit4 {
    @Autowired
    private User user;

    @Test
    public void test(){
        System.out.println(user);
        user.run();
    }
}
