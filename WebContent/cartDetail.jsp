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
            <table>
                <tr>
                    <th></th>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
                    
                <%
                    ArrayList<CakeInfor> carts = (ArrayList<CakeInfor>)session.getAttribute("cart");
                    for(int i = 0; i < carts.size(); i++){
                %>
                <tr>
                    <th></th>
                    <th>
                        <span class="cake_img"></span>
                        <span><%=carts.get(i).getCake().getName()%></span>
                    </th>
                    <th><%=carts.get(i).getCake().getPrice()%></th>
                    <th></th>
                    <th></th>                
                </tr>    
                
                <%}%>
            </table>
        </container>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
