package com.yb.spring6.aop.annoaop;

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
@Aspect //切面类
@Component    //在spring的IoC容器中进行管理
public class LogAspect {
    //设置切入点和通知类型
    //每个通知类型对应一个方法，在方法上添加注解表示通知类型
    //通知类型：
    // 切入点表达式: execution(权限修饰符 增强方法的返回类型 增强方法所在类的全路径.方法名称(方法参数))
    // 前置通知 @Before(value = "切入点表达式配置切入点")
    @Before(value = "execution(public int com.yb.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知   方法名称：" + methodName + "  参数：" + Arrays.toString(args));
    }
    // 返回通知 @AfterReturning
    //参数returning能得到增强的目标方法的返回值
    @AfterReturning(value = "execution(* com.yb.spring6.aop.annoaop.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知   方法名称：" + methodName  + ",返回结果；" + result);
    }
    // 异常通知 @AfterThrowing
    //目标方法执行过程中，出现了异常，这个通知会执行；在AfterThrowing中能够获取到目标方法的异常信息
    @AfterThrowing(value = "execution(* com.yb.spring6.aop.annoaop.CalculatorImpl.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知   方法名称：" + methodName + "，异常信息：" + ex);
    }
    // 后置通知 @After()
    @After(value = "com.yb.spring6.aop.annoaop.LogAspect.pointCut()")//如果不是同一个切面下，需要加上包的路径、类的名字，再调用方法
//    @After(value = "pointCut()")//同一个切面下，直接调用
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知   方法名称：" + methodName);
    }
    // 环绕通知 @Around()
    @Around("execution(*  com.yb.spring6.aop.annoaop.CalculatorImpl.*(..))")
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
    @Pointcut(value = "execution(*  com.yb.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void pointCut(){}

}
