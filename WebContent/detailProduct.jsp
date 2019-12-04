<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/detailProduct.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src="js/detailProduct.js"></script>
<title>Insert title here</title>
 <%@page import="model.*" %>
 <%@page import="modelDAO.*" %>
 <%@page import="java.util.List"%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<% Cake cake=(Cake)request.getAttribute("cake"); %>
	<% List<ImageUrl> listImage = ImageurlDAO.getByCakeID(cake.getID()); %>
    <div class="content">
        <div class="detail-product">
            <div class="row">
                <div class="col-6 image-product">
                    <div class="big-image">
                        <img src="assets/shop-img-1-600x600.jpg" class="image1" alt="">
                    </div>
                    <div class="small-images">
                        <img src="<%=listImage.get(0).getUrl() %>" class="image2" alt="">
                        <img src="assets/Black magic cake 1.jpg" class="image2" alt="">
                        <img src="assets/shop-small-img-1-1-300x300.jpg" class="image3" alt="">
                        <img src="assets/shop-small-img-1-4-300x300.jpg" class="image4" alt="">
                        <img src="assets/shop-small-img-1-2-300x300.jpg" class="image5" alt="">
                    </div>
                </div>
                <div class="col-6 info-product">
                    <div class="content-infor-product">
                        <img src="assets/Rating.JPG" alt="">
                        <h1>PAIN DEPICES</h1>
                        <h2>100.000</h2>
                        <p>Mel an esse salutandi, eos wisi nonumes democritum id. Eu affert dolore rationibus mel.
                             Porro vocent ut vel. Rebum deleniti voluptua at sed, ut tollit prodesset eum, ea eos nostrud.</p>
                        <div class="quantity">
                            <label for="">Quantity</label>
                            <span><i class='fas fa-caret-left' onclick="reduction()"></i></span>
                            <input type="text" value="1" id="quantity">
                            <span><i class='fas fa-caret-right' onclick="increase()"></i></span>
                        </div>
                        <button class="bt-add-to-cart">ADD TO CART</button>
                        <div class="product_meta">
                            <p class="sku_wrapper">SKU: <span class="sku">001</span></p>
                            <p class="posted_in">Category: <span class="category">Veggies</span></p>
                            <p class="tagged_as">Tag: <span class="tag">Spicy</span></p>
                        </div>
                    </div>
                        
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>