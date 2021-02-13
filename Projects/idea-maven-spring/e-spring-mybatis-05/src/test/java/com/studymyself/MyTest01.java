package com.studymyself;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    @Test
    public void test(){

        //定义配置文件路径
        String config = "applicationContext.xml";

        //创建Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取容器中的所有对象
        String[] beanNames = ac.getBeanDefinitionNames();

        //遍历beanNames
        for (String beanName:
             beanNames) {
            System.out.println("容器中的对象名称："+beanName+" = "+ac.getBean(beanName));
        }

    }

}
