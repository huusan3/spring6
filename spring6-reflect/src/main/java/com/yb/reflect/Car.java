package com.yb.reflect;

import org.springframework.cache.annotation.SpringCacheAnnotationParser;

/**
 * ClassName: Car
 * Package: com.yb.reflect
 * Description:
 *
 * @Author yang
 * @Create 2023/6/27 17:12
 * @Version
 */
public class Car {
    //属性
    private String name;
    private int age;
    private String color;

    //get、set方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //构造器
    public Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Car(){
    }

    //方法
    private void run(){
        System.out.println("私有方法，run...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
