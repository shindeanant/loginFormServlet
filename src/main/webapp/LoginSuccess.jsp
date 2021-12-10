<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page </title>
</head>
<body>
<h3>Hello <%= request.getAttribute("user") %>, Login successful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>