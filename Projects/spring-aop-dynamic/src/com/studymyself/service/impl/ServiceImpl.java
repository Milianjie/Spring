package com.studymyself.service.impl;

import com.studymyself.service.Service;

public class ServiceImpl implements Service {
    @Override
    public void doSome() {
        System.out.println("开始执行doSome方法中的业务代码...");
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务执行完毕！");
    }

    @Override
    public void doOther() {
        System.out.println("开始执行doOther方法中的业务代码...");
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务执行完毕！");
    }
}
