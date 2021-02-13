package com.studymyself;

import com.studymyself.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    /**
     * 测试使用Spring创建的对象
     */
    @Test
    public void testDoSome(){

        //1、指定Spring配置文件的路径及名称
        String config = "beans.xml";

        //2、创建代表Spring容器的对象，用ApplicationContext
        /*
            ApplicationContext是一个接口，Ctrl+H查看该接口的实现类，主要看的有两个：
        FileSystemXmlApplicationContext实现类：
            用这个类new容器对象获取Spring配置文件是从系统的硬盘中获取的，
            就是说Spring配置文件存储在d盘或其他盘中，构造方法中传的是带有
            硬盘路径的配置文件路径字符串
        ClassPathXmlApplicationContext实现类：
            表示new容器对象需要的Spring配置文件只从类的根路径下搜索，超出这个范围的配置文件
            会报错（这是最常用的，因为在resources目录中的配置文件编译后存放的就是类的根路径下target\classes）

         */
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //使用容器代表对象中获取类的对象的方法来获取需要的对象
        //getBean方法中参数可以传字符串类型的（配置文件中的bean的id），也可是Class类型的等等
        //这里将配置在配置类中的SomeServiceImpl类的id放进该方法中，
        // 由于该方法返回的是Object类型，强转成接口类型,多态
        SomeService someServiceImpl = (SomeService) ac.getBean("someService");

        //调用doSome方法
        someServiceImpl.doSome();
    }

    /*
        测试如何获取容器中Javabean的信息
     */
    @Test
    public void test01(){

        //1、指定Spring配置文件的路径及名称
        String config = "beans.xml";
        //2、创建代表Spring容器的对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        /*
            通过容器对象中的方法获取容器对象的信息
         */
        //获取容器中创建的javabean数量
        int count = ac.getBeanDefinitionCount();
        System.out.println("spring容器中创建的对象数量："+count+"\n========================================");

        //获取容器中创建的所有对象的id名称，返回的是一个
        String[] names = ac.getBeanDefinitionNames();
        for (String name:
             names) {
            System.out.println(name);
        }

    }

}
