package com.studymyself.bao02;

//目标方法
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //添加新功能：（目标方法执行之前）输出doSome方法执行时间
        System.out.println("==目标方法doSome执行==");
    }

    @Override
    public Object doOther(String name, int age) {
        //添加新功能：（目标方法执行之后）根据该方法的返回值做出相应处理
        System.out.println("+++目标方法doOther执行+++");
        return name;
    }
}
