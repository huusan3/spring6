package com.yb.spring6.iocxml.di1;

import java.util.Arrays;

/**
 * ClassName: Emp
 * Package: com.yb.spring6.iocxml.di1
 * Description:
 *
 * @Author yang
 * @Create 2023/6/19 17:05
 * @Version
 */
//员工类
public class Emp {
    //对象类型属性：员工属于某个部门
    private Dept dept;
    //员工名称
    private String ename;
    //员工年龄
    private int age;
    //爱好
    private String[] loves;

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public Dept getDept() {
        return dept;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void work(){
        System.out.println("emp " + ename + " is working... " + " and age is " + age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }

}
