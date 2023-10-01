package com.yb.spring6.iocxml.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestOrders
 * Package: com.yb.spring6.iocxml.scope
 * Description:
 *
 * @Author yang
 * @Create 2023/6/20 21:12
 * @Version
 */
public class TestOrders {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println(orders1);
        //scope为单实例时，orders和orders1的地址相同
        //单实例，在IoC容器初始化的时候进行创建对象
        //scope为多实例时，orders和orders1的地址不同
        //多实例，在获取bean的时候进行创建对象
    }
}
