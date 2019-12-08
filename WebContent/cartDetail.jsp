<%-- 
    Document   : cartDetail
    Created on : Dec 7, 2019, 12:03:08 AM
    Author     : Duck
--%>

<%@page import="model.CakeInfor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
        <link rel="stylesheet" href="css/detailCart.css">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <container>
            <table class="margin-content">
                <thead>
                    <tr>
                        <th></th>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<CakeInfor> carts = (ArrayList<CakeInfor>)session.getAttribute("cart");
                    for(int i = 0; i < carts.size(); i++){
                %>
                <tr id="product_<%=carts.get(i).getCake().getID()%>" class="each_product">
                    <th>
                        <button class="delete_product" onclick="deleteProduct('<%=carts.get(i).getCake().getID()%>', '${pageContext.request.contextPath}')">
                            X
                        </button>
                    </th>
                    <th class="product_info">
                        <span class="cake_img" style="background-image: url('<%=carts.get(i).getImgList()%>')"></span>
                        <a href="${pageContext.request.contextPath}/DetailProduct?id=<%=carts.get(i).getCake().getID()%>">
                            <%=carts.get(i).getCake().getName()%>
                        </a>
                    </th>
                    <th>
                        <span class="price_text product_price price_format"><%=carts.get(i).getCake().getPrice()%></span>
                        <span class="price_text"> VNĐ</span>
                    </th>
                    <th>
                        <div class="quantity">
                            <span class="pointer arrow" onclick="giamSL(this, '<%=carts.get(i).getCake().getID()%>')"><i class="fas fa-caret-left"></i></span>
                            <input class="quantity_product" min="1" type="text" value="<%=carts.get(i).getDem()%>" id="<%=carts.get(i).getCake().getID()%>">
                            <span class="pointer arrow" onclick="tangSL(this, '<%=carts.get(i).getCake().getID()%>')"><i class="fas fa-caret-right"></i></span>
                        </div>
                    </th>
                    <th class="price_text">
                        <span class="total_price_product price_format"></span>
                        <span class="price_text"> VNĐ</span>
                    </th>                
                </tr>    
                
                <%}%>
                </tbody>
            </table>
            <div class="margin-content option_button">
                <button class="button_cart"><a href="${pageContext.request.contextPath}/shop">BACK TO SHOP</a></button>
                <button class="button_cart" id="update_cart">UPDATE CART</button>
            </div>
         
            <div class="margin-content cart_total">
                <span>TOTAL : <span class="price_text price_format"></span><span class="price_text"> VNĐ</span></span>
                <button class="button_cart">CHECKOUT</button>
            </div>
        <container>
        <script src="js/detailCart.js"></script>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
