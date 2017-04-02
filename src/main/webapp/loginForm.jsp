<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2017/4/2
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h3>登录页面</h3>
    <font color="red">${requestScope.message}</font>
    <font color="red">账号、密码均为：admin</font>
    <form action="login" method="post">

        <table>
            <tr>
                <td><label>登录名：</label></td>
                <td><input type="text" id="loginName" name="loginName"/></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" id="password" name="password"/> </td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</body>
</html>
