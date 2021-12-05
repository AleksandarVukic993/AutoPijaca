<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.UserDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Profile </title>
</head>
<body>
    <jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
    <h1> User ${details.firstName} ${details.lastName} profile </h1>
    
    <a href="jsp/seller.jsp"> back to seller page </a>
    <br>
    <br>
    
    <img src = "ProfilePictures/${detils.firstName}.ifif">
    
    <table border = "1px">
        
        <tr>
            <td> Name: </td>
            <td> ${details.firstName} </td>
        </tr>
        
        <tr>
            <td> Last name: </td>
            <td> ${details.firstName} </td>
        </tr>
        
        <tr>
            <td> Contact </td>
            <td> ${details.contact.phone} </td>
            <td> ${details.contact.email} </td>
        </tr>
        
        <tr>
            <td> Address </td>
            <td> ${details.address.country} </td>
            <td> ${details.address.city} </td>
            <td> ${details.address.street} </td>
        </tr>
        
    </table>
    
</body>
</html>