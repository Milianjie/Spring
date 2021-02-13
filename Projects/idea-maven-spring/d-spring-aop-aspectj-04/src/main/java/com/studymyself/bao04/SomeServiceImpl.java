package com.studymyself.bao04;

//目标方法
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSecond(Integer a, Integer b) {
        //切面功能：目标方法出异常后，通过邮件、短信等方式发送异常信息到开发人员
        System.out.println("==doSecond方法执行=="+a/b);
    }
}
