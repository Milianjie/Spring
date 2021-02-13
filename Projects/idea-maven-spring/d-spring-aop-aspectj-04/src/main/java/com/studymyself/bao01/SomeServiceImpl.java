package com.studymyself.bao01;

//目标方法
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //添加新功能：（目标方法执行之前）输出doSome方法执行时间
        System.out.println("==目标方法doSome执行==");
    }
}
