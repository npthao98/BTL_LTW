<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/searchOrder.css">
<title>Search Order</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="search-order">
            <h1 class="title">Search order</h1>
            <div class="account-order-check">
                <p>Fill in the order number in the form below to track the shipping process of 
                    the product you have ordered</p>
                <div class="form-order-check">
                    <form>
                        <div class="ip-search">
                            <div class="form-group">
                                <label for="email">id orders: *</label>
                                <input class="form-control" id="order-checking-number">
                            </div>
                        </div>
    
                        <div class="bt-search">
                            <div class="form-group">
                                <button class="button" id="order-checking-submit"><span>Search Order</span></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="reasult-search">
                    <div class="order-mine">
                        <p><strong>order status # ON50007788</strong></p>
                        <p>successful delivery</p>
                    </div>
                    <div class="state-order">
                        <ul>
                            <li>
                                <div>
                                    <img src="assets/check.png">
                                </div>
                                <p>1. Received the order</p>
                            </li>
                            <li>
                                <div>
                                    <img src="assets/packing.png">
                                </div>
                                <p>2. Packing the goods</p>
                            </li>
                            <li>
                                <div>
                                    <img src="assets/transfer.png">
                                </div>
                                <p>3. Freight</p>
                            </li>
                            <li class="select-state">
                                <div >
                                    <img src="assets/receive.png" >
                                </div>
                                <p>4. Delivered</p>
                            </li>
                        </ul>
                    </div>
                </div>
               </div>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>