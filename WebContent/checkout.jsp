<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="checkout">
            <form action="#">
                <div class="customer-details">
                    <div class="row">
                        <div class="col-6 bill-details">
                            <h3 class="customer-details-item-title">BILLING DETAILS</h3>
                            <p class="form-row-narrow col-6">
                                <label class="form-row-title">First name*</label>
                                <input type="text" class="first-name" name="first-name" required>
                            </p>
                            <p class="form-row-narrow col-6">
                                <label class="form-row-title last-name-title">Last name*</label>
                                <input type="text" class="last-name" name="last-name" required>
                            </p>
                            <p class="form-row-wide">
                                <label class="form-row-title">Street address*</label>
                                <input type="text" class="street-address" name="street-address" required>
                            </p>
                            <p class="form-row-wide">
                                <label class="form-row-title">Town/City*</label>
                                <input type="text" class="town-city" name="town-city" required>
                            </p>
                            <p class="form-row-wide">
                                <label class="form-row-title">Phone*</label>
                                <input type="text" class="phone" name="phone" required>
                            </p>
                        </div>
                        <div class="col-6 add-information">
                            <h3 class="customer-details-item-title">ADDITIONAL INFORMATION</h3>
                            <p class="form-row-wide">
                                <label class="form-row-title">Order notes(optional)</label>
                                <textarea name="notes" id="" cols="5" rows="2"
                                          placeholder="Notes about your holder, e.g. special notes for delivery"></textarea>
                            </p>
                        </div>
                    </div>

                </div>
                <h3 class="order-review-heading">YOUR ORDER</h3>
                <div class="order-review">
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
                <div class="checkout-payment">
                    <p>Your personal data will be used to process your order,
                        support your experience throughout this website, and for other purposes described in our
                        <a href="#">privacy policy.</a>
                    </p>
                    <br>
                    <br>
                    <button type="submit" class="button-payment" name="woocommerce_checkout_place_order"
                            id="place_order" value="Place order" data-value="Place order">Place order</button>
                </div>
            </form>
        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>