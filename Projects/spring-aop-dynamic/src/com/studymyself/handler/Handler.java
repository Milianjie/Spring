package com.studymyself.handler;

import com.studymyself.util.ServiceTool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    //定义一个动态的目标类存储变量
    Object target = null;

    //在创建这个类的对象时将目标类对象给target赋值
    public Handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;
        //根据新功能需求，判断调用方法是doSome还是doOther
        if ("doSome".equals(method.getName())){

            //执行doSome时添加新功能
            //doSome执行的时间日志（非事务相关的功能，就是有没有下面方法中事务都能执行）
            ServiceTool.doLog();

            //执行doSome
            res = method.invoke(target,args);

            //doSome执行完后提交事务（非事务相关的功能，就是有没有上面方法中事务都能执行）
           ServiceTool.doTrans();

        }else if ("doOther".equals(method.getName())){

            //不添加新功能，直接执行doOther方法
           res = method.invoke(target, args);

        }
        return res;
    }
}
