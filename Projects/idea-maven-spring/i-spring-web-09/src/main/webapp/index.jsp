<%--
  Created by IntelliJ IDEA.
  User: 钟荣杰
  Date: 2021/2/13
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <p>注册用户</p>
    <form action="regs" method="post">
        <table>
            <tr>
                <td>登录名</td>
                <td><input type="text" name="loginName"></td>
            </tr>
            <tr>
                <td>登录密码</td>
                <td><input type="password" name="loginPwd"></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" name="realName"></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</body>
</html>
