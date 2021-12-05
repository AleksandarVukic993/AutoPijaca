<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page</title>
</head>
<body>
    
    <jsp:useBean id = "user" scope="session" class="model.User" ></jsp:useBean>
    
        <h1> Welcome ${user.userName} </h1>
        
        <label for="ShowUserForm">Show users:</label>
        <form id= "ShowUserForm" action="../AdminShowController" method="get">
            Choose what you'd like to see:
            <select name="userType" id="users">
                <option value="buyer">Buyer</option>
                <option value="seller">Seller</option>
                <option value="all">All</option>
            </select> <input type="submit" value="Show">
            
        </form>
        
        <br>
        <br>
        <label for="AddBalanceForm">Add balance</label>
        <form id= "AddBalanceForm" action="../AddBalanceController" method="get">
            
            User name:<input type="text" name="userName"> <br>
            Balance:<input type="text" name="balance"> <br>
            <input type="submit" value="Show">
        
        </form>
        
    </body>
</html>