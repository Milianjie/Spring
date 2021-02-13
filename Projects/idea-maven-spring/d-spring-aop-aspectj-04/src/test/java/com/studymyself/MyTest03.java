package com.studymyself;

import com.studymyself.bao03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {

    /**
     * 测试环绕通知的AOP实现
     */
    @Test
    public void testMyBefore(){

        //定义Spring配置文件路径
        String config = "applicationContext.xml";

        //创建Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取目标类对象或代理对象（前提这个类是实现了AOP情况下）
        SomeService proxy = (SomeService) ac.getBean("someService3");

        //直接执行接口中doFirst方法，验证是否进行了功能增强
        proxy.doFirst("zzz",0);//相当于直接执行切面类中的myAround方法
    }
}
