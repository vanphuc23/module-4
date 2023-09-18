<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/18/2023
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="listCalculator" method="post">
    <input type="number" name="number1">
    <input type="number" name="number2">
    <div style="display: flex">
        <div>
            <input type="submit" value="Addition(+)" name="btn">
        </div>
        <div>
            <input type="submit" value="Subtraction(-)" name="btn">
        </div>
        <div>
            <input type="submit" value="Multiplication(X)" name="btn">
        </div>
        <div>
            <input type="submit" value="Division(/)" name="btn">
        </div>
    </div>
</form>
<p>${num}</p>
</body>
</html>
