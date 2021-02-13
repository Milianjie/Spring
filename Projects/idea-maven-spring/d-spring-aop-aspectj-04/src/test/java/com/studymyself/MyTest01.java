package com.studymyself;

import com.studymyself.bao01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    /**
     * 测试前置通知的AOP实现
     */
    @Test
    public void testMyBefore(){

        //定义Spring配置文件路径
        String config = "applicationContext.xml";

        //创建Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取目标类对象或代理对象（前提这个类是实现了AOP情况下）
        SomeService proxy = (SomeService) ac.getBean("someService");

        //用反射获取该对象的完整类名，验证是是否是代理对象
        System.out.println("proxy对象完整类名："+proxy.getClass().getName());
        //proxy对象完整类名：com.sun.proxy.$Proxy8  -->确实是JDK动态代理的代理类名
        //当我们把切面类的切面表达式中方法参数写错或少写后输出如下:
        //proxy对象完整类名：com.studymyself.bao01.SomeServiceImpl
        //下面执行doSome方法也没有进行功能增强，所以写切面表达式时需要注意

        //直接执行接口中doSome方法，验证是否进行了功能增强
        proxy.doSome("jhfjkah",75757);
    }
}
