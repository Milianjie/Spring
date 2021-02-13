package com.studymyself.bao03;

//目标方法
public class SomeServiceImpl implements SomeService {

    @Override
    public Object doFirst(String name, Integer age) {
        //要增加的功能是：本方法执行前输出执行时间，执行后提交事务
        System.out.println("==目标方法doFirst执行==");
        return name+age;
    }

}
