package com.yb.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

/**
 * ClassName: TestBook
 * Package: com.yb.spring6.iocxml.di
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 15:28
 * @Version
 */
public class TestBook {
    @Test
    public void testSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testConstructor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book bookCon = context.getBean("bookCon", Book.class);
        System.out.println(bookCon);
    }
}
