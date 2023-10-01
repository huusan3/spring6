package com.yb.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * ClassName: ProxyFactory
 * Package: com.yb.spring6.aop.example
 * Description:
 *
 * @Author yang
 * @Create 2023/7/4 17:32
 * @Version
 */
public class ProxyFactory {
    //通过构造，传递目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    //返回代理对象
    public Object getProxy(){
        /*
            Proxy.newProxyInstance();
            参数1：ClassLoader loader 类加载器，加载动态生成代理类的类加载器
            参数2：Class<?> [] interfaces 目标对象实现的所有的接口的Class类型数组
            参数3：InvocationHandler 设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            //proxy:代理对象
            //method:代理对象需要实现（重写）目标对象的方法
            //args:method方法中的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法调用之前日志输出
                System.out.println("[动态代理][日志]" + method.getName() + ",参数：" + Arrays.toString(args));
                //调用目标的方法
                Object result = method.invoke(target, args);
                //方法调用之后日志输出
                System.out.println("[动态代理][日志]" + method.getName() + ",结果：" + result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
