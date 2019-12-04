<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/updateInformation.css">
<title>Update Information</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="update-information">
            <h1 class="a-title">THÔNG TIN TÀI KHOẢN</h1>
            <form action="/BTL_LTW/UpdateInformation" method="post">
            	<div class="box-update-information">
	                <div class="col-6">
	                    <label for="">Họ và tên:</label>
	                    <input type="text" value="Nguyễn Phương Thảo" name="name">
	                </div>
	                <div class="col-6">
	                    <label for="">Email:</label>
	                    <input type="text" value="a@gmail.com" name="email" readonly >
	                </div>
	                <div class="col-6">
	                    <label for="">SDT:</label>
	                    <input type="text" value="0339737700" name="phone" readonly>
	                </div>
	                <div class="col-6">
	                    <label for="">Ngày sinh:</label>
	                    <input type="text" value="12/04/1998" name="birth">
	                </div>
	                <div class="col-12">
	                    <label for="">Giới tính:</label>
	                    <select name="gender" id="">
	                        <option value="female">Nữ</option>
	                        <option value="male">Nam</option>
	                    </select>
	                </div>
	                <div class="col-12">
	                    <label for="">Địa chỉ:</label>
	                    <input type="text" value="jshkasjl" name="address">
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