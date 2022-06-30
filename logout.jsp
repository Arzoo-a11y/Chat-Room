<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>

    <title>::Sign out::</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="script.js"></script>
    <link rel="shortcut icon" href="icon.jpg" />

  </head>

  <body>
<% session.invalidate();%>
<center>
<h1>You are currently Signed out<br>
<a href="http://localhost:8080/Chat_Room/index.jsp">Login</a> to continue..
</h1>
</center>
  </body>
</html>