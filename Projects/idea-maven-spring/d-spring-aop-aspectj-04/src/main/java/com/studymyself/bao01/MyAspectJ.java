package com.studymyself.bao01;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
     * 切面类中前置通知的方法定义规则：
     * 1、公共方法，public修饰
     * 2、无返回值，void
     * 3、方法名自定义，但要见名知意
     * 4、方法参数可以有，也可以没有
     *     如果有参数，不能自定义，已经规定好了哪几类参数可以使用
     */

    /**
     * 注解@Before：前置注解
     *  属性value：值是切入点表达式，表示切面功能的执行位置（就是指定哪个目标方法增加功能）
     *  位置：写在定义方法上面
     *  该注解特有功能：
     *  1、使该切面在目标方法执行之前执行
     *  2、不改变目标方法执行结果
     *  3、不影响目标方法的执行
     */
    //切入点表达式简介写法：只写两个必须部分
    // @Before(value = "execution(void doSome(String,Integer))")
    //@Before(value = "execution(void *..SomeServiceImpl.doSome(String,Integer))")
    //切入点完整的表达式写法，注意目标方法不是写接口的,参数名不用写，只写参数类型
    //@Before(value = "execution( public void com.studymyself.bao01.SomeServiceImpl.doSome(String,Integer))")

    /**
     * 指定通知方法中的参数：JoinPoint
     * JoinPoint：连接点，即要加入切面功能的业务方法
     *      作用：
     *      在通知方法中获取业务方法的信息，如方法名、方法的实参等等。
     *      如果切面功能需要用到这些信息就加入JoinPoint类型参数
     *      该参数是由框架赋予值的，而且必须是第一位置的参数
     *      具体如下：
     */
    @Before(value = "execution( public void *..SomeServiceImpl.doSome(..))")
    public void myBefore(JoinPoint jp){

        //获取方法否完整定义
        System.out.println("方法的签名（定义）="+jp.getSignature());
        System.out.println("方法名="+jp.getSignature().getName());

        //获取方法的实参，有两个，一个返回的是Object数组，一个返回的是第一个实参
        Object[] args = jp.getArgs();
        for (Object arg:args){
            System.out.println("参数="+arg);
        }

        //增加的功能，即切面代码
        System.out.println("使用@Before前置通知的切面功能：输出目标方法执行时间\n"+new Date());
    }
}
//从上面我们就可以理解说一个切面要知道其三要素了，上面的
// @Before注解确定了切面的执行时间,而其中的value属性填的值是切入点表达式确定了该切面执行位置
//myBefore方法就确定了切面的功能。这三要素。