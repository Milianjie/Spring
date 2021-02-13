package com.studymyself.controller;

import com.studymyself.entity.User;
import com.studymyself.exceptions.InformationNotLegalException;
import com.studymyself.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 调用service中的方法完成用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //告诉Tomcat服务器POST请求体中的信息是UTF-8编码
        request.setCharacterEncoding("UTF-8");
        //获取请求中的注册信息
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        String realName = request.getParameter("realName");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /**
         * 一般方式获取容器对象和容器中的对象
         */
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //输出容器对象信息
//        out.print("容器对象信息：" +ac);
//        UserService userService = (UserService) ac.getBean("userService");

        /**
         * 获取全局范围内的容器对象
         */
        ApplicationContext ac = null;

//        //容器对象在ServletContext中的key值
//        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        //获取容器对象,获取ServletContext对象的this可以省略
//        Object attr = getServletContext().getAttribute(key);
//        if(attr instanceof ApplicationContext){
//            ac = (ApplicationContext) attr;
//        }

        //使用框架中的工具类方法获取容器对象
        ServletContext sc = getServletContext();
        //工具类中已经帮你强制转换好了
        ac = WebApplicationContextUtils.getWebApplicationContext(sc);

        //输出容器对象信息
        out.print("容器对象信息：" +ac);

        UserService userService = (UserService) ac.getBean("userService");
        User user = new User(loginName,loginPwd,realName);
        int count = 0;
        if (loginName!=null && loginPwd!=null &&realName!=null
                && loginName!=""&& loginPwd!="" &&realName!=""
        ){
            count = userService.addUser(user);
        }
        if (count!=0){
            out.print("<br>用户：<br>"+user+"<br>注册成功!");
           // request.getRequestDispatcher("/result.jsp").forward(request,response);
        }else {
            out.print("<br>用户名或密码或真实姓名不合法!");
            throw new InformationNotLegalException("用户名或密码或真实姓名不合法");
        }
    }

}
