<%-- 
    Document   : registAccount
    Created on : Dec 3, 2019, 10:44:38 AM
    Author     : Duck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
        <link rel="stylesheet" href="css/home.css">
        <title>Insert title here</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <form action="${pageContext.request.contextPath}/registAccount" method="POST">
            <input type="text" name="username">
            <input type="text" name="password">
            <input type="text" name="confirm_password">
            <input type="text" name="fullname">
            <input type="text" name="address">
            <input type="text" name="phone">
            <input type="text" name="email">
        </form>
       
        <script src="js/registAccount.js"></script>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
