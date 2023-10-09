<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/22/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mailBox" action="/" method="post">
    <table>
        <tr>
            <td><strong>Languages:</strong></td>
            <td>
                <form:select path="languages" items="${languages}"/>
            </td>
        </tr>
        <tr>
            <td><strong>Page Size:</strong></td>
            <td>
                Show <form:select path="size" items="${size}"/> emails per page
            </td>
        </tr>
        <tr>
            <td><strong>Spams filter:</strong></td>
            <td>
                <form:checkbox path="filter" value="true" label="Enable spams filter"/>
            </td>
        </tr>
        <tr>
            <td><strong>Signature:</strong></td>
            <td>
                <form:textarea path="signature" rows="5" cols="30"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>
            </td>
            <td>
                <input type="button" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
