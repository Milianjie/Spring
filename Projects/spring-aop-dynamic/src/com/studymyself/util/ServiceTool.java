package com.studymyself.util;

import java.util.Date;

public class ServiceTool {

    /**
     * 时间日志功能方法
     */
    public static void doLog(){
        System.out.println("doSome开始执行时间"+new Date());
    }

    /**
     * 提交事务功能方法
     */
    public static void doTrans(){
        System.out.println("正在提交事务...");
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("事务提交成功！");
    }
}
