package com.yb.spring6.iocxml.life;

/**
 * ClassName: User
 * Package: com.yb.spring6.iocxml.life
 * Description:
 *
 * @Author yang
 * @Create 2023/6/21 11:48
 * @Version
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }
    //无参数构造器
    public User(){
        System.out.println("1 bean对象创建，调用了无参构造器...");
    }

    public void setName(String name) {
        System.out.println("2 给bean对象设置属性值...");
        this.name = name;
    }

    //初始化的方法
    public void initMethod(){
        System.out.println("4 bean对象初始化，调用指定的方法初始化...");
    }

    //销毁的方法
    public void destroyMethod(){
        System.out.println("7 bean对象的销毁，调用指定的销毁方法...");
    }
}
