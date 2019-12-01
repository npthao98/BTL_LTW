<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/header.css">
	<title>Insert title here</title>
</head>
<body>
	<%@ include file="header_part.jsp" %>
		  
    <form action="/done" method="POST" class="margin-content login--form">
    	
        <h1 class="login_tittle">login</h1>
        <h3>Username :</h3>
        <input type="text" name="username" id="username" required>
        <h3>Password :</h3>
        <input type="password" name="password" id="password" required>
        </br>
        <button type="button" id="submit_form">Login</button>
    </form>    
    
    <script language="JavaScript" src="js/login.js"></script>
     <script language="JavaScript" src="js/header.js"></script>
</body>
</html>