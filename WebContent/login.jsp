<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
	<link rel="stylesheet" href="css/login.css">
	<title>Insert title here</title>
</head>
<body>
    
    <jsp:include page="header.jsp"/>
			  
    <form action="${pageContext.request.contextPath}/check_login" method="POST" class="margin-content login--form">
        <h1 class="login_tittle">login</h1>
        <h3>Username :</h3>
        <h4 id="error_message" class="error_message">${error}</h4>
        <%
            if(session.getAttribute("error") != null){
                session.setAttribute("error", null);
            }
        %>
        <input type="text" name="username" id="username" required>
        <h3>Password :</h3>
        <h4 id="password_error_message" class="error_message"></h4>
        <input type="password" name="password" id="password" required>
        </br>
        <button type="button" id="submit_form">Login</button>
        <button type="button" id="submit_form">
            <a style=" text-decoration: none; color: #fff;" href="${pageContext.request.contextPath}/regist">Regist accout</a>
        </button>
    </form>    

    <jsp:include page="footer.jsp"/>
    <script language="JavaScript" src="js/login.js"></script>
</body>
</html>