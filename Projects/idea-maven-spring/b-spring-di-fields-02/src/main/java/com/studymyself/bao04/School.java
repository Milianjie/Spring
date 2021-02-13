package com.studymyself.bao04;

public class School {

    private String name;
    private String addr;

    public void setName(String name) {
        System.out.println("Spring调用setName："+name);
        this.name = name;
    }

    public void setAddr(String addr) {
        System.out.println("Spring调用setAddr："+addr);
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
