<%@page import="controller.ProcessSys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/changePW.css">
<title>Insert title here</title>
</head>
<body>
	<% User user = (User)request.getAttribute("user"); %>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <form action="/BTL_LTW/ChangePW" method="post" accept-charset="ISO-8859-1" onsubmit="return checkInputChangePW()">
        	<div class="change-pw">
	            <h1 class="a-title">THÔNG TIN TÀI KHOẢN</h1>
	            <div class="box-change-PW">
	                <div class="col-6">
	                    <label for="">Mật khẩu:</label>
	                    <input type="password" id="pw1" name="pw1" required>
	                </div>
	                <div class="col-6">
	                    <label for="">Mật khẩu mới:</label>
	                    <input type="password" id="pw2" name="pw2" required>
	                </div>
	                <div class="col-6">
	                    <label for="">Nhắc lại mật khẩu mới:</label>
	                    <input type="password" id="pw3" name="pw3" required>
	                </div>
	                <div class="actions">
	                    <input type="submit" class="button" value="LƯU THAY ĐỔI">
	                    <a href="/BTL_LTW/Account" class="button cancel">HỦY</a>
	                </div>
	            </div>
	        </div>
        </form>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
<script type="text/javascript">
	function checkInputChangePW() {
		var pw1 = document.getElementById("pw1").value;
		var pw2 = document.querySelector('#pw2');
		var pw3 = document.getElementById("pw3").value;
		if(pw2.value != pw3){
			alert("Mật khẩu mới và mật khẩu mới nhập lại không trùng nhau.");
			return false;
		}
		else{
			if(pw2.value.length<=4){
				alert("Mật khẩu mới phải có ít nhất 5 kí tự.");
				return false;
			}
			else {
				return true;
			}
		}
	}
</script>
</html>