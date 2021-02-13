package com.studymyself.bao03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("school")
public class School {

    @Value("扫大街大学")
    private String name;
    @Value("美国")
    private String addr;

    public School() {
        System.out.println("School的无参数构造方法执行！");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
