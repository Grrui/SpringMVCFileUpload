<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2017/4/2
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>文件上传</h3>
    <form action="upload" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td><label>文件描述</label></td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td><label>请选择文件：</label></td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td><input type="submit" value="上传"/> </td>
            </tr>

                <c:forEach var="file" items="${requestScope.files}" >
                    <tr>
                        <td colspan="2"><a href="download?fileName=${file}">${file}</a><br></td>

                    </tr>
                </c:forEach>

        </table>
    </form>
</body>
</html>
