<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/searchOrder.css">
<title>Search Order</title>
</head>
<body>
<% Order order= (Order)request.getAttribute("order"); %>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="search-order">
            <h1 class="title">Tìm kiếm đơn hàng</h1>
            <div class="account-order-check">
                <p>Tìm kiếm đơn hàng để theo dõi quá trình vận chuyển sản phẩm bạn đã đặt hàng</p>
                <div class="form-order-check">
                    <form action="/BTL_LTW/SearchOrder" method="get">
                        <div class="ip-search">
                            <div class="form-group">
                                <label for="email">Mã đơn hàng: *</label>
                                <input class="form-control" id="order-checking-number" name="id">
                            </div>
                        </div>
    
                        <div class="bt-search">
                            <div class="form-group">
                                <input class="button" id="order-checking-submit" type="submit" value="Search Order">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="reasult-search">
                    <div class="order-mine">
                        <p><strong>Trạng thái đơn # <%=order.getID() %></strong></p>
                        <%if(order.getState()==0){%>
                        	<p>Đang chờ xác nhận</p>
                        <%}else if(order.getState()==1){ %>
                        	<p>Đã xác nhận</p>
                        <%}else if(order.getState()==2){ %>
                        	<p>Đang giao hàng</p>
                        <%}else if(order.getState()==3){ %>
                        	<p>Đã giao hàng</p>
                        <%}else{ %>
                        	<p>Đã hủy</p>
                        <%} %>
                        
                    </div>
                    <div class="state-order">
                        <ul>
                            <%if(order.getState()==0){ %>
	                    <li class="select-state">
	                        <div>
	                            <img src="assets/check.png">
	                        </div>
	                        <p>1. Chờ xác nhận</p>
	                    </li>
                    <%} else{
                    %>
                    	<li>
	                        <div>
	                            <img src="assets/check.png">
	                        </div>
	                        <p>1. Chờ xác nhận</p>
	                    </li>
                    <%} %>
                    <%if(order.getState()==1){ %>
	                    <li class="select-state">
	                        <div>
	                            <img src="assets/packing.png">
	                        </div>
	                        <p>2. Đã xác nhận</p>
	                    </li>
                    <%} else{
                    %>
                    	<li>
	                        <div>
	                            <img src="assets/packing.png">
	                        </div>
	                        <p>2. Đã xác nhận</p>
	                    </li>
                    <%} %>
                    <%if(order.getState()==2){ %>
	                    <li class="select-state">
	                        <div>
	                            <img src="assets/transfer.png">
	                        </div>
	                        <p>3. Đang giao hàng</p>
	                    </li>
                    <%} else{
                    %>
                    	<li>
	                        <div>
	                            <img src="assets/transfer.png">
	                        </div>
	                        <p>3. Đang giao hàng</p>
	                    </li>
                    <%} %>
                    <%if(order.getState()==3){ %>
	                    <li class="select-state">
	                        <div >
	                            <img src="assets/receive.png" >
	                        </div>
	                        <p>4. Đã giao hàng</p>
	                    </li>
                    <%} else{
                    %>
                    	<li>
	                        <div >
	                            <img src="assets/receive.png" >
	                        </div>
	                        <p>4. Đã giao hàng</p>
	                    </li>
                    <%} %>
                        </ul>
                    </div>
                </div>
               </div>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>