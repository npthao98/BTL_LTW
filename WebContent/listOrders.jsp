<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="css/listOrders.css">
<script src="js/listOrders.js"></script>
<title>List Orders</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="list-orders">
            <div class="col-12">
                <ul class="menu-state col-3">
                    <li>
                        <a href="#" onclick="home()">All orders</a>
                        <i id="arrow-home" class='fas fa-long-arrow-alt-left view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu1()">Waiting for confirm</a>
                        <i id="arrow-menu1" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu2()">Received</a>
                        <i id="arrow-menu2" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu3()">Packing and Freight</a>
                        <i id="arrow-menu3" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu4()">Delivered</a>
                        <i id="arrow-menu4" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                </ul>
                <div class="tab-content col-9">
                    <div id="home" class="view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">ID</th>
                                    <th class="none">Address</th>
                                    <th class="none">Phone</th>
                                    <th>Items</th>
                                    <th class="none">Price</th>
                                    <th>State</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td class="none">Ha Noi</td>
                                        <td>033*******</td>
                                        <td class="none">
                                            <p>1 milk</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                    <div id="menu1" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">ID</th>
                                    <th class="none">Address</th>
                                    <th class="none">Phone</th>
                                    <th>Items</th>
                                    <th class="none">Price</th>
                                    <th>State</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <div class="col-6">
                                                <a href="#" >
                                                    Details
                                                </a>
                                            </div>
                                            <div class="col-6">
                                                <a href="#" class="bt-right">
                                                    Cancel
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                    <div id="menu2" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">ID</th>
                                    <th class="none">Address</th>
                                    <th class="none">Phone</th>
                                    <th>Items</th>
                                    <th class="none">Price</th>
                                    <th>State</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="menu3" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">ID</th>
                                    <th class="none">Address</th>
                                    <th class="none">Phone</th>
                                    <th>Items</th>
                                    <th class="none">Price</th>
                                    <th>State</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td class="none">Ha Noi</td>
                                        <td>033*******</td>
                                        <td class="none">
                                            <p>1 milk</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="menu4" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">ID</th>
                                    <th class="none">Address</th>
                                    <th class="none">Phone</th>
                                    <th>Items</th>
                                    <th class="none">Price</th>
                                    <th>State</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td>
                                            <p>1 milk</p>
                                            <p>2 chocolate cakes</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td >
                                            <p>1 milk</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td class="none">Ha Noi</td>
                                        <td class="none">033*******</td>
                                        <td >
                                            <p>1 milk</p>
                                        </td>
                                        <td class="none">20.000</td>
                                        <td>Dang van chuyen</td>
                                        <td>
                                            <a href="#">
                                                Details
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
	<jsp:include page="footer.jsp"/>
</body>
</html>