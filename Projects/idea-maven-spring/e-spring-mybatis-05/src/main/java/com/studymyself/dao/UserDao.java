package com.studymyself.dao;

import com.studymyself.entity.User;

import java.util.List;

public interface UserDao {
    //定义两个方法就行了

    //添加数据方法
    public Integer insertUser(User user);

    //查询方法
    public List<User> selectAll();
}
