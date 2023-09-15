<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/15/2023
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
    </tr>
    <c:forEach items="${list}" var="student" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
