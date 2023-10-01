package com.yb.spring6;

/**
 * ClassName: User
 * Package: com.yb.spring6
 * Description:
 *
 * @Author yang
 * @Create 2023/6/13 16:05
 * @Version
 */
public class User {
    //无参数构造器
    public User(){
        System.out.println("0: 无参数构造器执行了...");
    }

    public void add(){
        System.out.println("add...");
    }

    //传统实现创建对象
    public static void main(String[] args){
        User user = new User();
        user.add();
    }
}
