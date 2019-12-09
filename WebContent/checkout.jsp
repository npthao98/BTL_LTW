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
<link rel="stylesheet" href="css/checkout.css">
<title>Insert title here</title>
</head>
<body>
	<% 
		List<CakeInfor> list=(List<CakeInfor>)request.getAttribute("list");
		Client user=(Client)request.getAttribute("client");
	%>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="checkout">
            <form action="${pageContext.request.contextPath}/Checkout" method="post">
                <div class="customer-details">
                    <div class="row">
                    	
                        <div class="col-6 bill-details">
                            <h3 class="customer-details-item-title">CHI TIẾT ĐƠN HÀNG</h3>
                            <p class="form-row-wide">
                                <label class="form-row-title">Họ và tên*</label>
                                <input type="text" class="first-name" name="first-name" value="<%=user.getName() %>" readonly>
                            </p>
                            <p class="form-row-wide">
                                <label label class="form-row-title">Số điện thoại*</label>
                                <input type="text" class="last-name" name="phone" value="<%=user.getPhone() %>" readonly >
                            </p>
                            <p class="form-row-wide">
                                <label class="form-row-title">Địa chỉ*</label>
                                <input type="text" class="street-address" name="address" value="<%=user.getAddress() %>" required>
                            </p>
                        </div>
                        <div class="col-6 add-information">
                            <h3 class="customer-details-item-title">Thông tin thêm</h3>
                            <p class="form-row-wide">
                                <label class="form-row-title">Chú ý(tùy chọn)</label>
                                <textarea name="notes" id="" cols="5" rows="2"
                                          placeholder=""></textarea>
                            </p>
                        </div>
                    </div>

                </div>
                <h3 class="order-review-heading">Danh sách sản phẩm</h3>
                <div class="order-review">
                    <table class="shop_table">
                        <thead>
                            <tr>
                                <th class="product-name">Sản phẩm</th>
                                <th class="product-total">Tổng tiền</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% int total=0;
                        for(int i=0; i<list.size(); i++){ 
                        	total = total+ list.get(i).getCake().getPrice()*list.get(i).getDem();
                        %>
                        	
	                        <tr class="cart_item">
	                            <td class="product-name">
	                                <%=list.get(i).getCake().getName() %>&nbsp;
	                                <strong class="product-quantity">× <%=list.get(i).getDem() %></strong>
	                            </td>
	                            <td class="product-total">
	                                <span class="woocommerce-Price-amount amount">
	                                    <%=list.get(i).getCake().getPrice()*list.get(i).getDem() %>
	                                </span>
	                            </td>
	                        </tr>
                        <%} %>
                        </tbody>
                        <tfoot>
                            <tr class="cart-subtotal">
                                <th>Tổng tiền</th>
                                <td>
                                    <span class="woocommerce-Price-amount amount">
                                        <%=total %>
                                    </span>
                                </td>
                            </tr>
                            <tr class="order-total">
                                <th>Tổng thanh toán</th>
                                <td>
                                    <strong>
                                        <span class="woocommerce-Price-amount amount">
                                            <%=total %>
                                        </span>
                                    </strong>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="checkout-payment">
                    <button type="submit" class="button-payment" name="woocommerce_checkout_place_order"
                            id="place_order" value="Place order" data-value="Place order">Đặt đơn</button>
                </div>
            </form>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>