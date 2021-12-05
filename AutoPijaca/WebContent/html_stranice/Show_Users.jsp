<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>

    <jsp:useBean id="users" scope="request" class="java.util.ArrayList"></jsp:useBean>

    <a href = "jsp/Admin.jsp"> back to admin page </a>

    <h1>Table of users</h1>
    
    <table border = 3>
        
        <tr>
            <th>User Name</th>
            <th>Password</th>
            <th>User Type</th>
        </tr>
        
        <c:forEach var = "u" items="${users}">
            <tr>
                <td>${u.userName}</td>
                <td>${u.password}</td>
                <td>${u.userType}</td>
            </tr>
        </c:forEach>
    
    </table>

</body>
</html>