package com.studymyself.bao04;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
     * 异常通知定义方法规则：
     *  1、公共方法，public修饰
     *  2、无返回值
     *  3、方法名自定义，但要见名知意
     *  4、方法有参数。参数类型Exception，还有就是JoinPoint（但要放在参数第一位置）
     *
     */

    /**
     * @AfterThrowing:异常通知
     *   属性：
     *      value：切人入点表达式
     *      throwing：名称自定义，存储的是目标方法抛出的异常对象，
     *                参数中形参名要和该名称一致
     *   位置：通知方法上面
     *   特点：
     *   1、在目标方法抛出异常时执行
     *   2、可以做异常的监控，监控目标执行时是不是有异常
     *      如果有异常就通过邮件或短信等方式发送异常
     *
     *      执行的就是：
     *      try{
     *          someServiceImpl.doSecond(..)
     *      }catch{
     *          myAfterThrowing(..)
     *      }
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",throwing = "ex")
    public void myAfterThrowing(Exception ex){

        System.out.println("异常通知：目标方法发生异常执行，异常信息："+ex.getMessage());
        //下面语句模拟发送异常
        try {
            Thread.sleep(1000*3);
            System.out.println("登录默认邮箱中...");
            Thread.sleep(1000*3);
            System.out.println("邮箱登录成功！");
            Thread.sleep(1000*3);
            System.out.println("选择默认收件人...");
            Thread.sleep(1000*3);
            System.out.println("正在发送异常信息邮件...");
            Thread.sleep(1000*3);
            System.out.println("发送成功！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
