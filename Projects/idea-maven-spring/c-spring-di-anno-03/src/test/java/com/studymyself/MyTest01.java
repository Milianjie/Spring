package com.studymyself;

import com.studymyself.bao01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    @Test
    public void testStudent(){

        //配置文件路径
        String config = "applicationContext.xml";

        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取Student类对象
        Student student1 = (Student) ac.getBean("student01");
        System.out.println("第一次获取的student1"+student1);
        Student student2 = (Student) ac.getBean("student02");
        System.out.println("再次获取的student1"+student2);

    }

}
