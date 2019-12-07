<%-- <%@ page import="java.util.ArrayList" %> --%>
<%-- <%@ page import="model.entity.OrderBill" %>
<%--   Created by IntelliJ IDEA. --%>
<%--   User: DELL --%>
<%--   Date: 10/31/2019 --%>
<%--   Time: 10:26 PM --%>
<%--   To change this template use File | Settings | File Templates. --%>
<%-- --%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button{
            width: 4cm;
            height: 2cm;
            text-align: center;
            font-style: oblique ;
            font-size: 20px;

        }
        a.button{
		    display: inline-block;
		    text-align: center;
		    width: 105px;
		    padding: 13px 0px;
		    font-size: 14px;
/* 		    color: black; */
		    border: 1px solid transparent;
		    cursor: pointer;
		    z-index: 3;
		}
		a.button:hover{
			color: red;
		}
		a, a:hover{
			text-decoration: none;
		}
    </style>
</head>
<body>
<%
//     if((session.getAttribute("staffIsAuthenticated") != "true") ||
//             session == null || session.getAttribute("staffIsAuthenticated") == null) response.sendRedirect("staff_login.jsp");
%>
<div style="text-align: end;font-size: 25px; width: 100%; height: 100px;float: left">
    <a href="/BTL_LTW/StaffChangePW" class="button">ĐỔI MẬT KHẨU</a>
    <a href="/BTL_LTW/StaffLogout" class="button">ĐĂNG XUẤT</a>
</div>
<div style="width: 100%; text-align: center; font-size: 100px; padding-top: 60px;">Staff Home</div>
<div style="text-align: right; height: 50px;font-size: 50px">
    <a href="order_handle.jsp" style="display: none">Chi tiết đơn hàng</a>
</div>
<div style="width: 100%;text-align: center;height: 500px">
    <div style="margin-bottom: 20px">
    	<a href="/BTL_LTW/StaffListOrders">
	        <button>Quản lí đơn hàng</button>
	    </a>
    </div>
    <div>
    	<a href="follow-add-book">
	        <button>Quản lí sản phẩm</button>
	    </a>
    </div>
    
</div>


</body>
</html>
