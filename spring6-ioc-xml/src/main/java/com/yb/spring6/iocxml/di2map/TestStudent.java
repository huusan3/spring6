package com.yb.spring6.iocxml.di2map;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestStudent
 * Package: com.yb.spring6.iocxml.di2map
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 14:34
 * @Version
 */
public class TestStudent {
    @Test
    public void testStu(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di1-5.xml");
        Student student = context.getBean("student_p", Student.class);
        student.run();
    }
}
