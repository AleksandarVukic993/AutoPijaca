<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add balance</title>
</head>
<body>
    <h1> Adding balance </h1>
    
    <a href = "Admin.jsp"> Back to admin page </a>
    
    <form action="../AddBalanceController" method="get">
        User name: <input type="text" name = "userName"><br/><br/>
        Balance: <input type="text" name = "balance"><br/><br/>
        <input type="submit" value="Add balance">
    </form>
    
</body>
</html>