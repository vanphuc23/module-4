<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/15/2023
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/create" method="post">
    <table>
        <tr>
            <lable>ID:</lable>
            <input type="number" name="id">
        </tr>
        <tr>
            <lable>Name:</lable>
            <input type="text" name="name">
        </tr>
        <tr>
            <button>CREATE</button>
        </tr>
    </table>
    <a href="/student/list">Quay lại menu</a>
</form>
</body>
</html>
