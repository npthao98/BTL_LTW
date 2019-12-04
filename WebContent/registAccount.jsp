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
        <link rel="stylesheet" href="css/regist.css">
        <title>Insert title here</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <form action="${pageContext.request.contextPath}/regist" method="POST" class="margin-content" id="form_regist">
            <h2>Đăng ký tài khoản</h2>
            <h3>Tên đăng nhập :</h3>
            <h4 class="error_username error_message">${error}</h4>
            <%
                if(session.getAttribute("error") != null){
                    session.setAttribute("error", null);
                }
            %>
            <input type="text" name="username" id="username" oninput="clearErr('username')" onchange="checkInfor('username', this)">
            <h3>Mật khẩu</h3>
            <h4 class="error_password error_message"></h4>
            <input type="password" name="password" id="password" oninput="clearErr('pass')" onchange="checkInfor('pass', this)">
            <h3>Xác nhận lại mật khẩu :</h3>
            <h4 class="error_confirmpassword error_message"></h4>
            <input type="password" name="confirm_password" id="confirm_password" oninput="clearErr('confirm_pass')" onchange="checkInfor('confirm_pass', this)">
            <h3>Họ tên của bạn :</h3>
            <h4 class="error_name error_message"></h4>
            <input type="text" name="fullname" id="fullname" onchange="checkInfor('fullname', this)" oninput="clearErr('fullname')">
            <h3>Địa chỉ :</h3>
            <h4 class="error_addr error_message"></h4>
            <input type="text" name="address" id="address" onchange="checkInfor('address', this)" oninput="clearErr('address')">
            <h3>Số điện thoại :</h3>
            <h4 class="error_tele error_message"></h4>
            <input type="number" name="phone" id="phone" onchange="checkInfor('phone', this)" oninput="clearErr('phone')">
            <h3>Email :</h3>
            <h4 class="error_email error_message"></h4>
            <input type="text" name="email" id="email" onchange="checkInfor('email', this)" oninput="clearErr('email')">
            </br>
            <button type="button" class="regist_button">Đăng ký </button>
        </form>
       
        <script src="js/registAccount.js"></script>
        
        <jsp:include page="footer.jsp"/>

        
    </body>
    

</html>
