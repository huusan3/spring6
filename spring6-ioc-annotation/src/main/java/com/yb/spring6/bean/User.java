package com.yb.spring6.bean;

import org.springframework.stereotype.Component;

/**
 * ClassName: User
 * Package: com.yb.spring6.bean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/25 11:27
 * @Version
 */
@Component(value = "user") //相当于<bean id="user" class="..."></bean>
                           //value可以不写，默认为类名同名，且将首字母小写
public class User {
}
