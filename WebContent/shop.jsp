<%-- 
    Document   : shop
    Created on : Dec 5, 2019, 12:51:36 AM
    Author     : Duck
--%>

<%@page import="controller.ProcessSys"%>
<%@page import="java.util.Collections"%>
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
        <link rel="stylesheet" href="css/shop.css">
        <title>Products</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <%
            ArrayList<CakeInfor> products = (ArrayList<CakeInfor>)session.getAttribute("products");
            ArrayList<CakeInfor> list = new ArrayList<CakeInfor>();
            
            String sort = (String)request.getParameter("sort");
            String type = (String)request.getParameter("type");
            
            String url = "shop?";
            int ID_type = 0, sort_mode = 0, number_record;
            
            if(type != null){
                try {
                    ID_type = Integer.parseInt(type);
                } catch (NumberFormatException nfe) {
                    ID_type = 0;
                }
                if(1 <= ID_type && ID_type <= 10){
                    url = url + "type=" + type + "&";
                    list = ProcessSys.filterType(products, ID_type);
                }
                else
                    list = products;
            }else{
                list = products;
            }
            
            if(sort != null){
                try {
                    sort_mode = Integer.parseInt(sort);
                } catch (NumberFormatException nfe) {
                    sort_mode = 0;
                }
                if(sort_mode == 1){
                    Collections.sort(list);
                }else{
                    if(sort_mode == 2){
                        Collections.sort(list);
                        Collections.reverse(list);
                    }else{
                        list = products;
                    }if(sort_mode == 0){
                        list = products;
                    }
                }
            }
            
            number_record = list.size();
        %>
        <container class="margin-content">
            <div class="list_products">
                <div class="products_filter">
                    <div class="number_product">Hiển thị từ 1 - <%=number_record%> sản phẩm</div>
                    <div class="filter_show">
                        Lọc sản phẩm theo :
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/<%=url%>sort=0">Tất cả sản phẩm</a></li>
                            <li><a href="${pageContext.request.contextPath}/<%=url%>sort=1">Giá tăng dần</a></li>
                            <li><a href="${pageContext.request.contextPath}/<%=url%>sort=2">Giá giảm dần</a></li>
                        </ul>
                    </div>
                </div>
 
                <div class="products_list">
                <%                   
                   for(int i = 0; i < number_record; i++){
                %>
                    <div class="each_product">
                        <a class="product_img" style="background-image: url('<%=list.get(i).getImgList()%>')" onclick="show('${pageContext.request.contextPath}/DetailProduct?id=<%=list.get(i).getCake().getID()%>')">
                            <button class="button_add_cart" type="button" onclick="addCart(this, '<%=list.get(i).getCake().getID()%>', '${pageContext.request.contextPath}')">
                                <i class="fas fa-shopping-cart"></i>
                                ADD TO CART
                            </button>
                        </a>
                        <div class="infor-product">
                            <div class="feedback_star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h3><%=list.get(i).getCake().getName()%></h3>
                            <p class="price_product"><%=list.get(i).getCake().getPrice()%></p>
                        </div>
                    </div>
                <%}%>
                </div>
                <div>
                   
                </div>
            </div>
            
            <div class="list_catgories">
                <h2>CATEGORIES</h2>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/shop?type=1">Cupcake</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=2">Fruit cake</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=3">Roll cake</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=4">Chocolate Cake</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=5">Desert</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=6">Breakfast</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=7">Cake of season</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=8">Cheese cake</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=9">Cookies</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop?type=10">Basic cake</a></li>
                </ul>
            </div>
        </container>
     
        <script src="js/shop.js"></script>
     
        <jsp:include page="footer.jsp"/>
        
    </body>
</html>
