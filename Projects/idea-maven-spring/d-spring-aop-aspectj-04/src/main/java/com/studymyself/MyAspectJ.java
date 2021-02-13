package com.studymyself;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

/**
 * @Aspect:这是AspectJ框架的注解
 *   作用：表示当前类是切面类
 *   切面类：用来给业务方法增加功能的类，里面有切面功能的代码
 *   位置：写在定义类的上面
 */
@Aspect
public class MyAspectJ {

    /**
     * @Pointcut注解：定义和切入管理点。
     *      当项目中的多个切入点表达式的内容是重复的，或者说的可以复用的。
     *      就可以使用@Pointcut
     *     属性：
     *     value：可以复用的切入点表达式
     *     位置：写在自定义的一个私有无参数的方法上，该方法无需内容
     *   特点：
     *      该注解定义在一个方法上，这时该方法的“方法名()”就代表了该注解中的切入点表达式
     *      所以在通知注解中的value属性的值就可以直接填“方法名()”，非常便捷
     */
    //写一个自定义方法，建议私有的无参数的，然后添加@Pointcut
    @Pointcut(value = "execution(* *..SomeServiceImpl.doOther(..))")
    private void myExecution(){
        //无需代码
    }

    //@Before(value = "execution(* *..SomeServiceImpl.doOther(..))")
    @Before(value = "myExecution()")
    public void myBefore(JoinPoint jp){

        //增加的功能，即切面代码
        System.out.println("使用@Before前置通知的切面功能：输出目标方法执行时间\n"+new Date());
    }


    //@AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",returning = "res")
    @AfterReturning(value = "myExecution()",returning = "res")
    public void myAfterReturning(Object res){
        //Object res;是目标方法执行后的返回值，根据返回值做切面功能的不同处理
        if (res!=null){

            System.out.println("后置通知：添加对返回值的判断做出的功能，输出返回值："+res);

        }else {
            System.out.println("参数为空");
        }

    }


}
