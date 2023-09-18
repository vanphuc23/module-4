<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/18/2023
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="listSandwich" method="post">
<h1>Sandwich Condiments</h1>
<div style="display: flex">
    <div>
        <input type="checkbox" name="condiments" id="lettuce" value="Lettuce">
        <label for="lettuce">Lettuce</label>
    </div>
    <div>
        <input type="checkbox" name="condiments" id="tomato" value="Tomato">
        <label for="tomato">Tomato</label>
    </div>
    <div>
        <input type="checkbox" name="condiments" id="mustard" value="Mustard">
        <label for="mustard">Mustard</label>
    </div>
    <div>
        <input type="checkbox" name="condiments" id="sprouts" value="Sprouts">
        <label for="sprouts">Sprouts</label>
    </div>
</div>
<hr>
<button>Save</button>
    <br>
    <c:forEach items="${condiments}" var="condiments">
        <p><c:out value="${condiments}"/></p>
    </c:forEach>
</form>
</body>
</html>
