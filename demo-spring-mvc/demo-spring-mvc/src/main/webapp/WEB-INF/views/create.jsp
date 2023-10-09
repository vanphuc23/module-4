<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%--<form action="/student/create" method="post">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <lable>ID:</lable>--%>
<%--            <input type="number" name="id">--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <lable>Name:</lable>--%>
<%--            <input type="text" name="name">--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <button>CREATE</button>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <a href="/student/list">Quay lại menu</a>--%>
<%--</form>--%>


<form:form modelAttribute="student" method="post" action="/student/create">
    ID: <form:input path="id"/><br>
    Name: <form:input path="name"/><br>
    Class: <form:select path="className" >
    <form:options items="${listClass}"/>
</form:select><br>
<%--    Gender: <form:radiobutton path="gender" value="1" label="Nam"/>--%>
<%--  <form:radiobutton path="gender" value="0" label="Nữ"/>--%>
<%--    <form:radiobutton path="gender" value="-1" label="Ngân men"/><br>--%>
    Gender: <form:radiobuttons path="gender" items="${listGender}"/><br>
    Language: <form:checkboxes path="languages" items="${languages}"/><br>
    <form:button>Mi điên hà Ngân</form:button>
</form:form>
</body>
</html>
