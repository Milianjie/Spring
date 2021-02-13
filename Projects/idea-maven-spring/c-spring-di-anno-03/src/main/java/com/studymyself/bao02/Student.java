package com.studymyself.bao02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("student02")
public class Student {

    public Student() {
        System.out.println("Student02无参构造方法执行！");
    }

    /**
     * @Value:简单类型属性赋值
     *      注解中的属性value：在注解中该属性是String类型的，所以需要用双引号括起来
     *   使用方法：
     *   1、使用在类中的属性上面，不调用set方法，底层使用反射机制赋值该属性，推荐使用
     *   2、使用在java类的set方法上，调用该方法进行属性的赋值
     *   下面展示使用在属性字段上
     *   该注解配置的组件扫描器跟@Component一样，所以无需多配置该注解的组件扫描器
     *   扫描@Component时也会扫描@Value
     */
    @Value("终南山")//value可省略
    private String name;
    @Value(value = "5214")
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
