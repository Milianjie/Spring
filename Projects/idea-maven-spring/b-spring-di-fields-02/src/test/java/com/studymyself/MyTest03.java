package com.studymyself;

import com.studymyself.bao04.Student04;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {

    /**
     * 测试多个配置文件
     */
    @Test
    public void testStudent01(){

        //填写主配置文件路径
        String config = "bao04/total.xml";

        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取容器中的对象，强制转换Student01类型
        Student04 student04 = (Student04) ac.getBean("student04");
        //输出对象
        System.out.println(student04);

    }

}
