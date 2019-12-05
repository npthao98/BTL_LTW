<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/detailOrderSuccess.css">
<title>Detail Order Success</title>
</head>
<body>
<% 
	Order order=(Order)request.getAttribute("order");
	Client client=(Client)request.getAttribute("client");
    List<Cake> cakes = (List<Cake>)request.getAttribute("cakes"); 
    List<Cake_Order> cakeOrders = (List<Cake_Order>)request.getAttribute("cakeOrders"); 
%>
<jsp:include page="header.jsp"/>
<div class="content">
    <div class="detail-order-success">
        <form action="#">
            <div class="customer-details">
                <div class="row">
                    <h3 class="customer-details-item-title">CHI TIẾT SẢN PHẨM</h3>
                    <div class="col-6 bill-details">
                        <div class="order-revieiw">
                            <table class="shop_table">
                                <thead>
                                <tr>
                                    <th class="product-name">Sản phẩm</th>
                                    <th class="product-total">Thành tiền</th>
                                </tr>
                                </thead>
                                <tbody>
                                <% int total=0; 
                                for(int i=0; i<cakes.size(); i++){ %>
	                                <tr class="cart_item">
	                                    <td class="product-name">
	                                        <%=cakes.get(i).getName() %>&nbsp;
	                                        <strong class="product-quantity">× 
	                                        	<%for(int j=0; j<cakeOrders.size(); j++){ 
	                                        		if(cakeOrders.get(j).getCakeID()==cakes.get(i).getID()){
	                                        			%>
	                                        			<%= cakeOrders.get(j).getQuantity() %>
	                                        			<% 
	                                        			break;
	                                        		}
	                                        	} %>
	                                        </strong>
	                                    </td>
	                                    <td class="product-total">
	                                <span class="woocommerce-Price-amount amount">
<!-- 	                                    <span class="woocommerce-Price-currencySymbol">$</span> -->
	                                    <% int price = 0;
	                                    for(int j=0; j<cakeOrders.size(); j++){ 
	                                        		if(cakeOrders.get(j).getCakeID()==cakes.get(i).getID()){
	                                        			price = price + cakeOrders.get(j).getQuantity()*cakes.get(i).getPrice();
	                                        			break;
	                                        		}
	                                      }
	                                    total+=price;
	                                      %>
	                                      <%=price %>
	                                </span>
	                                    </td>
	                                </tr>
                                <%} %>
                                </tbody>
                                <tfoot>
                                <tr class="cart-subtotal">
                                    <th>Tổng phụ</th>
                                    <td>
                                    <span class="woocommerce-Price-amount amount">
<!--                                         <span class="woocommerce-Price-currencySymbol">$</span> -->
                                        <%=total %>
                                    </span>
                                    </td>
                                </tr>
                                <tr class="cart-subtotal">
                                    <th>Phương thức thanh toán</th>
                                    <td>
                                    <span class="woocommerce-Price-amount amount">
                                        COD
                                    </span>
                                    </td>
                                </tr>
                                <tr class="order-total">
                                    <th>Tổng tiền</th>
                                    <td>
                                        <strong>
                                        <span class="woocommerce-Price-amount amount">
<!--                                             <span class="woocommerce-Price-currencySymbol">$</span> -->
                                            <%=total %>
                                        </span>
                                        </strong>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                    <div class="col-6 bill-information">
                        <h4>ĐƠN HÀNG CHI TIẾT</h4>
                        <ul style="    padding-left: 50px;"">
                            <li>
                                <label>Mã đơn: </label>
                                <span><%=order.getID() %></span>
                            </li>
                            <li>
                                <label>Thời gian đặt: </label>
                                <span><%=order.getTime() %></span>
                            </li>
                            <li>
                                <label>Tên người nhận: </label>
                                <span><%=client.getName() %></span>
                            </li>
                            <li>
                                <label>Địa chỉ: </label>
                                <span><%=client.getAddress() %></span>
                            </li>
                            <li>
                                <label>SDT: </label>
                                <span><%=client.getPhone() %></span>
                            </li>
                        </ul>
                    </div>
                </div>

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
            <div class="checkout-payment">
                <button type="submit" class="button-payment" name="woocommerce_checkout_place_order"
                        id="place_order" value="Place order" data-value="Place order">Back main page</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>