<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/updateInformation.css">
<title>Update Information</title>
</head>
<body>
	<% Client user = (Client)session.getAttribute("user"); %>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="update-information">
            <h1 class="a-title">CẬP NHẬT TÀI KHOẢN</h1>
            <form action="/BTL_LTW/UpdateInformation" method="post" accept-charset="ISO-8859-1">
            	<div class="box-update-information">
	                <div class="col-6">
	                    <label for="">Họ và tên:</label>
	                    <input type="text" value="<%= user.getName() %>" name="name">
	                </div>
	                <div class="col-6">
	                    <label for="">Email:</label>
	                    <input type="text" value="<%= user.getEmail() %>" name="email" readonly >
	                </div>
	                <div class="col-6">
	                    <label for="">SDT:</label>
	                    <input type="text" value="<%= user.getPhone() %>" name="phone" readonly>
	                </div>
<!-- 	                <div class="col-6"> -->
<!-- 	                    <label for="">Ngày sinh:</label> -->
<!-- 	                    <input type="text" value="12/04/1998" name="birth"> -->
<!-- 	                </div> -->
<!-- 	                <div class="col-12"> -->
<!-- 	                    <label for="">Giới tính:</label> -->
<!-- 	                    <select name="gender" id=""> -->
<!-- 	                        <option value="female">Nữ</option> -->
<!-- 	                        <option value="male">Nam</option> -->
<!-- 	                    </select> -->
<!-- 	                </div> -->
	                <div class="col-12">
	                    <label for="">Địa chỉ:</label>
	                    <input type="text" value="<%= user.getAddress() %>" name="address">
	                </div>
	                <div class="actions">
	                    <input type="submit" class="button" value="LƯU THAY ĐỔI">
	                    <a href="/BTL_LTW/Account" class="button cancel">HỦY</a>
	                </div>
	            </div>
            </form>
            
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>