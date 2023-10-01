package com.yb.spring6.aop.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestAop
 * Package: com.yb.spring6.aop.annoaop
 * Description:
 *
 * @Author yang
 * @Create 2023/7/5 17:37
 * @Version
 */
public class TestAop {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(6,7);
    }
}
