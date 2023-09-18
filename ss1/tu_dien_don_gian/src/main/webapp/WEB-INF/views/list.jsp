<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/18/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="list" method="post">
<lable>Từ: </lable>
<input type="text" name="dictionary" value="<c:out value="${dictionary}"/>">
<button>submit</button>
</form>
<p>${mess}</p>
</body>
</html>
