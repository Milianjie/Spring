package com.studymyself.bao03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("student03")
public class Student {

    public Student() {
        System.out.println("Student03无参构造方法执行！");
    }

    @Value("终南山")//value可省略
    private String name;
    @Value(value = "5214")
    private int age;

    /**
     * 引用类型注解赋值
     * @Autowired：Spring提供的注解，实现引用类型的赋值
     * 注解实现引用类型的赋值，使用的是自动注入原理，即方式有byType和byName
     * @Autowired注解默认使用byType方式，因为该方式只需要将该注解放到引用类
     * 型属性上面就行了，不需要添加其他东西
     *
     * 使用方式：
     *      1、放在在引用类型属性定义上面，该方式不使用set方法，推荐使用
     *      2、放在属性的set方法上，调用set方法赋值
     *
     * @Autowired注解中有一个属性required，是boolean类型的，默认值为true
     * 一般我们使用@Autowired注解时，不指定该属性的值时，
     *          默认为true，效果就是在为该引用类型属性赋值失败后，会抛出异常，终止整个程序执行
     *          当我们设置为false时，即使赋值失败，程序正常执行，结果只是该引用属性的值为null而已
     *          一般我们设定required值为true，可以提早发现程序异常
     *          特殊情况设置为false
     *
     * @Autowired使用byName方式：
     * 除了在引用类型定义上用@Autowired注解外，还需要添加@Qualifier(value"bean的id")注解
     *  该方式是Spring底层通过查找由@Qualifier(value"bean的id")提供的名为id的对象，判断是否是
     *  引用类型的数据类型，然后赋值给引用变量
     *
     */
    //使用byType方式的@Autowired
    @Autowired
    private School school;

//    //使用byName方式的@Autowired
//    @Autowired
//    @Qualifier("student")
//    private School school;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
