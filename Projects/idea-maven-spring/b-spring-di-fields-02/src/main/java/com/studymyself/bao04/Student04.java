package com.studymyself.bao04;


public class Student04 {

    private String name;
    private int age;

    //引用类型的字段
    private School school;

    public void setName(String name) {
        System.out.println("Spring调用setName："+name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("Spring调用setAge："+age);
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("Spring调用setSchool："+school);
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student03{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
