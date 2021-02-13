package com.studymyself.service;

import com.studymyself.entity.User;

import java.util.List;

public interface UserService {

    public Integer addUser(User user);

    public List<User> queryAll();


}
