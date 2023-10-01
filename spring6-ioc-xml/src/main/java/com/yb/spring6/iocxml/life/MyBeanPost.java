package com.yb.spring6.iocxml.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ClassName: MyBeanPost
 * Package: com.yb.spring6.iocxml.life
 * Description:
 *
 * @Author yang
 * @Create 2023/6/21 15:57
 * @Version
 */
public class MyBeanPost implements BeanPostProcessor {
    //后置处理器需要在配置文件中进行配置
    //bean后置处理器不是单独针对某一个bean生效，而是针对IoC容器中所有bean都会执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3 bean后置处理器，在初始化之前执行...");
        System.out.println(beanName + "::" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 bean后置处理器，在初始化之后执行...");
        System.out.println(beanName +"::" + bean);
        return bean;
    }
}
