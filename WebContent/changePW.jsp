<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/changePW.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="change-pw">
            <h1 class="a-title">THÔNG TIN TÀI KHOẢN</h1>
            <div class="box-change-PW">
                <div class="col-6">
                    <label for="">Mật khẩu:</label>
                    <input type="password" name="pw1">
                </div>
                <div class="col-6">
                    <label for="">Mật khẩu mới:</label>
                    <input type="password" name="pw2" >
                </div>
                <div class="col-6">
                    <label for="">Nhắc lại mật khẩu mới:</label>
                    <input type="password" name="pw3">
                </div>
                <div class="actions">
                    <a href="#" class="button">LƯU THAY ĐỔI</a>
                    <a href="#" class="button cancel">HỦY</a>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>