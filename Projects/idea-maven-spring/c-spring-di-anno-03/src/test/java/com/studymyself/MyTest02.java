package com.studymyself;

import com.studymyself.bao02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {

    @Test
    public void testStudent(){

        //配置文件路径
        String config = "applicationContext.xml";

        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取Student类对象
        Student student1 = (Student) ac.getBean("student02");
        System.out.println("第一次获取的student1"+student1);

    }

}
