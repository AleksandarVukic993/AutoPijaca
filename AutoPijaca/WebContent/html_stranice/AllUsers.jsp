<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> All Users </title>
</head>
<body>
    <h1> All users </h1>
    
    <a href = "jsp/Admin.jsp"> Back to admin page </a>
    
    <p> Form for user search </p>
        <form action="../AdminController" method="get">
        
            <input type="submit" value="Search">
        </form>
        
        <%
        List<User> listOfUsers = (List<User>)request.getAttribute("listOfUsers");
        %>
        
        <table border = "1px">
        <tr>
            <th>ID</th>
            <th>USER NAME</th>
            <th>PASSWORD</th>
        </tr>
        
        <%
            if(listOfUsers != null){
            for(User u: listOfUsers){
        %>
        
            <tr>
                <td><%=u.getIdUser() %></td>
                <td><%=u.getUserName() %></td>
                <td><%=u.getPassword() %></td>
                <td><%=u.getUserType() %></td>
            </tr>
        
        <%
            }
                 }
        %>
        
        </table>
    
</body>
</html>