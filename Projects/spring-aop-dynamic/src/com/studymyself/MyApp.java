package com.studymyself;

import com.studymyself.handler.Handler;
import com.studymyself.service.Service;
import com.studymyself.service.impl.ServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {

    public static void main(String[] args) {

        //使用JDK的Proxy类中的方法动态创建代理对象

        //创建目标类对象,使用多态
        Service target = new ServiceImpl();

        //创建InvocationHandler接口实现类对象
        InvocationHandler handler = new Handler(target);

        //使用JDK中Proxy类中的静态方法创建代理对象，为了能够使用目标类接口的方法
        //方法的返回对象要强制转换成目标类的接口类型
        Service proxy = (Service) Proxy.newProxyInstance(
                ServiceImpl.class.getClassLoader(),//目标类的类加载器
                ServiceImpl.class.getInterfaces(),//目标类的接口
                handler//InvocationHandler接口实现类对象
        );

        //用这个代理对象执行接口中的方法
        proxy.doOther();
        System.out.println("====================================");
        proxy.doSome();
    }

}
