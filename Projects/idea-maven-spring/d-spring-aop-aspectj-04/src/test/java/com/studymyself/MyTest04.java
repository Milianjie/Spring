package com.studymyself;

import com.studymyself.bao04.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {

    /**
     * 测试异常通知的AOP实现
     */
    @Test
    public void testMyAfterThrowing(){

        //定义Spring配置文件路径
        String config = "applicationContext.xml";

        //创建Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取目标类对象或代理对象（前提这个类是实现了AOP情况下）
        SomeService proxy = (SomeService) ac.getBean("someService4");

        //直接执行接口中doSecond方法，验证是否进行了功能增强
        proxy.doSecond(5,0);
    }
}
