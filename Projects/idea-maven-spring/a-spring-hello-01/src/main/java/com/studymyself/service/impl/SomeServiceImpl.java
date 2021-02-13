package com.studymyself.service.impl;

import com.studymyself.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl() {

        System.out.println("SomeServiceImpl的无参数构造方法执行");

    }

    @Override
    public void doSome() {
        System.out.println("Hello Spring!!!");
    }
}
