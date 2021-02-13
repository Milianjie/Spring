package com.studymyself;

import com.studymyself.entity.User;
import com.studymyself.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest02 {

    @Test
    public void test(){

        //定义配置文件路径
        String config = "applicationContext.xml";

        //创建Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取service对象
        UserService userService = (UserService) ac.getBean("userService");

//        //创建User对象，并赋值
//        User user = new User("milianjie@github.com","555555","精英文学社");
//
//        //向数据库插入数据
//        //spring整合mybatis时，不需要sqlSession.commit(),事务是自动提交的
//        int count = userService.addUser(user);
//        System.out.println("成功添加记录条数："+count);

        //查询所有数据
        List<User> users = userService.queryAll();
        for (User user:
             users) {
            System.out.println(user);
        }

    }

}
