package com.studymyself.entity;

public class User {
    //是属性名和数据库表的列名一样
    private Integer id;
    private String loginName;
    private String loginPwd;
    private String realName;

    //为了方便赋值，可以把无参数构造方法和有参数构造方法创建出来
    public User() {
    }

    public User(String loginName, String loginPwd, String realName) {

        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.realName = realName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
