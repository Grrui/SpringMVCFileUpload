<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2017/4/2
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>success</title>
</head>
<body>
this is success.jsp!!<br>
<c:forEach var="file" items="${requestScope.files}" >
    <a href="download?filename=${file}">${file}</a><br>
</c:forEach>

</body>
</html>
