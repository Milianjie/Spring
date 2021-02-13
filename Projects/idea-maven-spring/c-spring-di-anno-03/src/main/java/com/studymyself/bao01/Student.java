package com.studymyself.bao01;

import org.springframework.stereotype.Component;

/**
 * 注解@Component：
 *        创建对象，相当于配置文件的<bean></bean>功能
 *        其中有个属性value：填的是对象的名称，相当于bean标签中的id
 *        value的值在该项目中是唯一的，创建的对象在Spring容器中只有一个，单例
 *        位置：在类的上面，如下所示
 *
 * Spring中和@Component注解功能一致可创建对象的注解还有：
 * @Reposoitory（用在持久层的类上面）：
 *        用在dao类上，表示创建dao实现类对象，dao类对象是能够访问数据库的
 * @Service（用在业务逻辑层的类上面）：
 *        放在service类上，创建service实现类对象，这类对象做业务处理，有事务的功能等
 * @Controller（用在控制器上）：
 *        放在处理器（控制器）类上，创建控制器对象，该对象能够接收用户输入参数，显示处理请求结果
 *  上面三个和@Component注解都能创建对象，但各自都具有额外的功能
 *  使得项目的各个对象分层，声明了该对象是属于什么层对象，有什么特定能力
 * @Component注解一般用在不知道放到什么层中的Java类上面
 * 所以这四个注解并不是功能一模一样的注解
 */
//标准使用该注解写法
//@Component(value = "myStudent")

//学注解的时候知道，注解属性名为value时，且只需要写value时可以省略value
//@Component("myStudent")

//也可以不指定对象的名称，默认命名为首字母小写的类名
@Component("student01")
public class Student {

    public Student() {
        System.out.println("Student01无参构造方法执行！");
    }

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
