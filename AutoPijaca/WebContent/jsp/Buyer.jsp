<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Buyer page</title>
    </head>
    <body>
        
        <%
        
           User user = (User)session.getAttribute("user");
        
        %>
        
        <h1>Welcome buyer <%=user.getUserName() %></h1>
        
        <p> This is dinamic table </p>
        <table border = 1px>
             <tr>
                 <th>Dinamic serial number</th>
                 <th>Dinamic name</th>
             </tr>
        <%
            for(int i = 1; i < 10; i++){
            	
            
        %>
            <tr>
                <td><%=i %></td>
                <td>Name<%=i %></td>
            </tr>
        <%
            }
        %>
        </table>
        
    </body>
</html>