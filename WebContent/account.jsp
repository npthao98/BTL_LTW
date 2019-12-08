<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/account.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<% Client user = (Client)session.getAttribute("user"); %>
    <div class="content">
        <div class="account">
            <h1 class="a-title">THÔNG TIN TÀI KHOẢN</h1>
            <div class="box-account">
                <div class="row">
                    <div class="col-7">
                        <div class="detail-account">
                            <p>
                                <span class="label">Họ và tên:</span>
                                <span><%= user.getName()  %></span>
                            </p>
                            <p>
                                <span class="label">Email:</span>
                                <span><%= user.getEmail()  %></span>
                            </p>
                            <p>
                                <span class="label">Điện thoại:</span>
                                <span><%= user.getPhone()  %></span>
                            </p>
<!--                             <p> -->
<!--                                 <span class="label">Ngày sinh:</span> -->
<!--                                 <span></span> -->
<!--                             </p> -->
<!--                             <p> -->
<!--                                 <span class="label">Giới tính:</span> -->
<!--                                 <span>Nữ</span> -->
<!--                             </p> -->
                            <p>
                                <span class="label">Địa chỉ:</span>
                                <span><%= user.getAddress()  %></span>
                            </p>
<!--                             <p> -->
<!--                                 <span class="label">Quận/Huyện:</span> -->
<!--                                 <span></span> -->
<!--                             </p> -->
<!--                             <p> -->
<!--                                 <span class="label">Thành phố/Tỉnh:</span> -->
<!--                                 <span></span> -->
<!--                             </p> -->
                        </div>
                    </div>
                    <div class="col-5">
                        <div class="actions">
                            <div class="update-inf">
                                <a href="${pageContext.request.contextPath}/UpdateInformation" class="button">SỬA THÔNG TIN</a>
                            </div>
                            <div class="change-pw">
                                <a href="${pageContext.request.contextPath}/ChangePW" class="button">THAY ĐỔI MẬT KHẨU</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>