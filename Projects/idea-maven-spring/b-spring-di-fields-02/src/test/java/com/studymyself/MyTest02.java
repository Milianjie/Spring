package com.studymyself;

import com.studymyself.bao03.Student03;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {

    /**
     * 测试自动注入
     */
    @Test
    public void testStudent01(){

        //定义配置文件路径
        String config = "bao03/applicationContext.xml";

        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取容器中的对象，强制转换Student01类型
        Student03 student03 = (Student03) ac.getBean("student03");
        //输出对象
        System.out.println(student03);

    }

}
