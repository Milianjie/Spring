package com.studymyself;

import com.studymyself.bao01.Student01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    /**
     * 测试di实现基于XML的set注入
     */
    @Test
    public void testStudent01(){

        //定义配置文件路径
        String config = "bao01/applicationContext.xml";

        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取容器中的对象，强制转换Student01类型
        Student01 student01 = (Student01) ac.getBean("student01");
        //输出对象
        System.out.println(student01);

    }

}
