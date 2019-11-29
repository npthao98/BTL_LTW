<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="header.jsp"/>
<div class="content">
    <div class="detail-order-success">
        <form action="#">
            <div class="customer-details">
                <div class="row">
                    <h3 class="customer-details-item-title">BILL DETAILS</h3>
                    <div class="col-6 bill-details">
                        <div class="order-revieiw">
                            <table class="shop_table">
                                <thead>
                                <tr>
                                    <th class="product-name">Product</th>
                                    <th class="product-total">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="cart_item">
                                    <td class="product-name">
                                        Coffee Intense&nbsp;
                                        <strong class="product-quantity">× 1</strong>
                                    </td>
                                    <td class="product-total">
                                <span class="woocommerce-Price-amount amount">
                                    <span class="woocommerce-Price-currencySymbol">$</span>
                                    40.00
                                </span>
                                    </td>
                                </tr>
                                <tr class="cart_item">
                                    <td class="product-name">
                                        Roule Saucisse&nbsp;
                                        <strong class="product-quantity">× 1</strong>
                                    </td>
                                    <td class="product-total">
                                <span class="woocommerce-Price-amount amount">
                                    <span class="woocommerce-Price-currencySymbol">$</span>
                                    29.00
                                </span>
                                    </td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr class="cart-subtotal">
                                    <th>Subtotal</th>
                                    <td>
                                    <span class="woocommerce-Price-amount amount">
                                        <span class="woocommerce-Price-currencySymbol">$</span>
                                        69.00
                                    </span>
                                    </td>
                                </tr>
                                <tr class="cart-subtotal">
                                    <th>payment method</th>
                                    <td>
                                    <span class="woocommerce-Price-amount amount">
                                        COD
                                    </span>
                                    </td>
                                </tr>
                                <tr class="order-total">
                                    <th>Total</th>
                                    <td>
                                        <strong>
                                        <span class="woocommerce-Price-amount amount">
                                            <span class="woocommerce-Price-currencySymbol">$</span>
                                            69.00
                                        </span>
                                        </strong>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                    <div class="col-6 bill-information">
                        <h4>Thanks for trusting us</h4>
                        <ul style="    padding-left: 50px;"">
                            <li>
                                <label>Order id: </label>
                                <span>1183</span>
                            </li>
                            <li>
                                <label>Datetime: </label>
                                <span>11h59 12/04/2020</span>
                            </li>
                            <li>
                                <label>Name: </label>
                                <span>Nguyễn Phương Thảo</span>
                            </li>
                            <li>
                                <label>Detail address: </label>
                                <span>Nhà 11 ngõ 32</span>
                            </li>
                            <li>
                                <label>Town/City:</label>
                                <span>Hà Nội</span>
                            </li>
                            <li>
                                <label>Phone: </label>
                                <span>033********</span>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
            <div class="state-order">
                <ul>
                    <li>
                        <div>
                            <img src="images/check.png">
                        </div>
                        <p>1. Received the order</p>
                    </li>
                    <li>
                        <div>
                            <img src="images/packing.png">
                        </div>
                        <p>2. Packing the goods</p>
                    </li>
                    <li>
                        <div>
                            <img src="images/transfer.png">
                        </div>
                        <p>3. Freight</p>
                    </li>
                    <li class="select-state">
                        <div >
                            <img src="images/receive.png" >
                        </div>
                        <p>4. Delivered</p>
                    </li>
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