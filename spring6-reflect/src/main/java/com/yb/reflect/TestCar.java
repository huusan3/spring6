package com.yb.reflect;

import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassName: TestCAR
 * Package: com.yb.reflect
 * Description:
 *
 * @Author yang
 * @Create 2023/6/27 17:16
 * @Version
 */
public class TestCar {
    //1.获取Class对象的多种方式
    @Test
    public void test1() throws Exception {
        //1.1 类名.class
        Class clazz1 = Car.class;
        //1.2 对象.getClass
        Class clazz2 = new Car().getClass();
        //1.3 Class.forName("类的全路径")
        Class clazz3 = Class.forName("com.yb.reflect.Car");

        //实例化（创建一个对象）
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    //2.获取构造方法
    @Test
    public void test2() throws Exception{
        Class clazz = Car.class;
        //获取所有的构造
        //getConstructors()：获取所有public权限的构造器方法
//        Constructor[] constructors = clazz.getConstructors();
        //getDeclaredConstructors()：获取所有的构造器方法，无论public、private
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor c : constructors){
            System.out.println("构造器名称:" + c.getName() + " 参数个数：" + c.getParameterCount());
        }

        //指定有参构造器创建对象
        //1 构造是public
//        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car) c1.newInstance("BMW", 10, "red");
//        System.out.println(car1);

        //2 构造是private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);//该设置表示可以访问私有的(private)的构造
        Car car2 = (Car) c2.newInstance("BMW", 4, "black");
        System.out.println(car2);
    }

    //3.获取属性
    @Test
    public void test3() throws Exception{
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        //获取所有public属性
//        Field[] fields = clazz.getFields();
        //获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            if(f.getName().equals("name")){
                //设置允许访问
                f.setAccessible(true);
                f.set(car,"BMW");
            }
            System.out.println(f.getName());
            System.out.println(car);
        }
    }

    //4.获取类中的所有方法，并通过对象调用方法
    @Test
    public void test4() throws Exception{
        Car car = new Car("BMW",3,"blue");
        Class clazz = car.getClass();
        //1 public方法
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
//            System.out.println(method.getName());
            //执行方法 toString
            if(method.getName().equals("toString")){
                String invoke = (String) method.invoke(car);
                System.out.println("toString()执行了" + invoke);
            }
        }

        //2 private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for(Method m : methodsAll){
            //执行方法 run()
            if(m.getName().equals("run")){
                m.setAccessible(true);
                m.invoke(car);
            }
        }
    }
}
