package com.studymyself.service;

import com.studymyself.dao.UserDao;
import com.studymyself.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    //定义dao接口类型属性
    UserDao userDao;

    //因为本项目不用注解注入，所以定义一个set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer addUser(User user) {
        //在现实的开发中，service的方法中通常是做很多的判断以及很多
        //业务处理等功能的，然后才决定要不要插入数据的。在一个service
        //方法中可能会调用多个dao的方法，这里只是演示，所以就只有调用
        //dao接口中的方法
        int count = userDao.insertUser(user);
        return count;
    }

    @Override
    public List<User> queryAll() {
        List<User> userList = userDao.selectAll();
        return userList;
    }
}
