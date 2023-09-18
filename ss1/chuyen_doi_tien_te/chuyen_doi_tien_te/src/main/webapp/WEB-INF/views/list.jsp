<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/15/2023
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator/list" method="post">
    <table>
        <tr>
            <td><lable>USD:</lable></td>
            <td><input type="number" name=usd></td>
        </tr>
        <tr>
            <td></td>
            <td><button>trade</button></td>
        </tr>
    </table>
</form>
<p><c:out value="${vnd}"/></p>
</body>
</html>
