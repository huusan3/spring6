package com.yb.bean;

import com.yb.annotation.Bean;
import com.yb.annotation.Di;
import org.springframework.beans.factory.BeanFactory;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: AnnotationApplicationContext
 * Package: com.yb.bean
 * Description:
 *
 * @Author yang
 * @Create 2023/6/30 16:38
 * @Version
 */
public class AnnotationApplicationContext implements ApplicationContext{
    //创建map集合，放bean对象的容器（模拟IoC）
    private static Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //创建有参数构造，传递包路径，设置包扫描规则
    //当前包及其子包，哪个类上有@Bean注解，把这个类通过反射进行实例化
    public AnnotationApplicationContext(String basePackage){
        try {
            //com.yb
            // 1 将 . 替换成 \
            String packagePath = basePackage.replaceAll("\\.", "\\\\");

            // 2 获取包的绝对路径（编译后的带盘符路径）
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                //获取包前面路径的部分，进行字符串截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
//                System.out.println(filePath);
                //包的扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //完成属性注入
        loadDi();
    }

    //包扫描，实例化
    private void loadBean(File file) throws Exception{
        // 1 判断当前的内容是否是文件夹
        if(file.isDirectory()){
            // 2 获取文件夹中的所有内容
            File[] childrenFiles = file.listFiles();

            // 3 判断文件夹中内容是否为空，空则直接返回
            if(childrenFiles == null || childrenFiles.length == 0){
                return;
            }

            // 4 如果文件夹不为空，遍历文件夹中的所有内容
            for(File child : childrenFiles){
                // 4.1 遍历得到的每个File对象，继续判断，如果还是文件夹，递归
                if(child.isDirectory()){
                    //递归
                    loadBean(child);
                }else{
                    // 4.2 遍历得到的File对象，不是文件夹，是一个文件
                    // 4.3 得到包的路径+类名称的部分（字符串截取）
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);

                    // 4.4 判断当前文件类型是否为 .class
                    if(pathWithClass.contains(".class")){
                        // 4.5 如果是.class类型，将路径中的\替换成. 并把.class去掉
                        // com.yb.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        // 4.6 判断类上面是否有@Bean注解，如果有，使用反射进行实例化
                        // 4.6.1 获取类的Class
                        Class<?> clazz = Class.forName(allName);

                        // 4.6.2 判断是不是接口
                        if(!clazz.isInterface()){
                            // 4.6.3 判断类上面是否有@Bean注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                // 4.6.4 进行实例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 4.7 把对象实例化后，放入map集合beanFactory
                                // 4.7.1 判断当前类如果有接口，就让接口的class作为map的key，如果没有接口，就自己的class作为key
                                if(clazz.getInterfaces().length > 0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else{
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //属性注入
    private void loadDi() {
        // 1 实例化的对象在beanFactory的map集合中，先把beanFactory的map集合遍历
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for(Map.Entry<Class,Object> entry : entries){
            // 2 得到每个对象及每个对象(value)，以及每个对象中的属性
            Object obj = entry.getValue();
            // 2.1 获取对象Class
            Class<?> clazz = obj.getClass();
            // 2.2 获取每个对象中的属性
            Field[] declaredFields = clazz.getDeclaredFields();

            // 3 遍历得到的每个对象的属性的数组，得到每个属性
            for(Field field : declaredFields){
                // 4 判断属性上是否有@Di的注解
                Di annotation = field.getAnnotation(Di.class);
                if(annotation != null){
                    //如果是私有属性，需要设置为可以设置值
                    field.setAccessible(true);
                    // 5 如果有@Di注解，把对象进行设置、注入
                    try {
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
