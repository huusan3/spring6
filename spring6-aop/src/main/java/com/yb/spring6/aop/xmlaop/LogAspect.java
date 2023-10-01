package com.yb.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ClassName: LogAspect
 * Package: com.yb.spring6.aop.annoaop
 * Description:
 *
 * @Author yang
 * @Create 2023/7/5 12:00
 * @Version
 */
//切面类

@Component    //在spring的IoC容器中进行管理
public class LogAspect {
    //前置通知
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知   方法名称：" + methodName + "  参数：" + Arrays.toString(args));
    }
    // 返回通知
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知   方法名称：" + methodName  + ",返回结果；" + result);
    }
    // 异常通知
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知   方法名称：" + methodName + "，异常信息：" + ex);
    }
    // 后置通知
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知   方法名称：" + methodName);
    }
    // 环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try{
            System.out.println("环绕通知==目标方法之前执行（相当于前置通知）");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后执行（相当于返回通知）");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常时执行（相当于异常通知）");
        }finally {
            System.out.println("环绕通知==目标方法执行完毕后执行（相当于后置通知）");
        }
        return result;
    }

    //重用切入点表达式
    @Pointcut(value = "execution(*  com.yb.spring6.aop.xmlaop.CalculatorImpl.*(..))")
    public void pointCut(){}

}
