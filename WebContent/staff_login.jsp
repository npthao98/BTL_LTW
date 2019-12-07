<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/1/2019
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error_message{
            font-family: Muli,sans-serif;
            color: red;
            height: 22px;
            margin: 10px 0 0 0;
            padding-left: 50px;
            padding-bottom: 10px;
            font-style: italic;
        }
    </style>
</head>
<body>
<div style="width: 100%; text-align: center; font-size: 100px; padding-top: 60px;">WELCOME TO BOOK STORE</div>
<div style="width: 100%;text-align: center;font-size: 30px">This page for staff only</div>
<div style="margin-left: 42%; margin-top: 10%;">
    
    <form action="${pageContext.request.contextPath}/staff_login" method="post">
        <h4 id="error_message" class="error_message">${error}</h4>
        <input style="width: 25%; min-height: 30px;" type="text" name="staff-username" placeholder="Tên đăng nhập..."><br><br>
        <input style="width: 25%; min-height: 30px;" type="password" name="staff-password" placeholder="Mật khẩu..."><br><br>
        <button type="submit" style="margin-left: 8%; min-width: 10%; min-height: 3%;">Đăng nhập</button>
    </form>
    <%
        if(session.getAttribute("error") != null){
            session.setAttribute("error", null);
        }
    %>
    <label style="margin-left: 4vh" id="authentication-message">

    </label>
</div>
</body>
</html>
