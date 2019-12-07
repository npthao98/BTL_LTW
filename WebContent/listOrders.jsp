<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<% 
	List<OrderDetail> orders=(List<OrderDetail>)request.getAttribute("orders");
	Client client=(Client)request.getAttribute("client");
%>
	<jsp:include page="header.jsp"/>
    <div class="content">
        <div class="list-orders">
            <div class="col-12">
            
                <ul class="menu-state col-3">
                    <li>
                        <a href="#" onclick="home()">Tất cả</a>
                        <i id="arrow-home" class='fas fa-long-arrow-alt-left view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu1()">Chờ xác nhận</a>
                        <i id="arrow-menu1" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu2()">Đã xác nhận</a>
                        <i id="arrow-menu2" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu3()">Đang giao</a>
                        <i id="arrow-menu3" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu4()">Đã giao</a>
                        <i id="arrow-menu4" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                    <li>
                        <a href="#" onclick="menu5()">Đã Hủy</a>
                        <i id="arrow-menu5" class='fas fa-long-arrow-alt-left none-view2'></i>
                    </li>
                </ul>
                <div class="tab-content col-9">
                    <div id="home" class="view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">STT</th>
                                    <th class="none">Địa chỉ</th>
                                    <th class="none">Số điện thoại</th>
                                    <th>Mặt hàng</th>
                                    <th class="none">Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                	<%for(int i=0; i<orders.size(); i++){ %>
                                		<tr>
	                                        <td><%=i+1 %></td>
	                                        <td class="none"><%=orders.get(i).getAddress() %></td>
	                                        <td class="none"><%=client.getPhone() %></td>
	                                        <td>
	                                            <%for(int j=0; j<orders.get(i).getOrderItem().size(); j++){ %>
		                                        		<p><%=orders.get(i).getOrderItem().get(j).getQuantity() %>
		                                        		 &nbsp;<%=orders.get(i).getOrderItem().get(j).getCakeName() %></p>
		                                        	<%} %>
	                                        </td>
	                                        <td class="none"><%=orders.get(i).getTotal() %></td>
	                                        <td>
	                                        	<%if(orders.get(i).getState()==0){ %>
	                                        		Chờ xác nhận
	                                        	<%}else if(orders.get(i).getState()==1){ %>
	                                        		Đã xác nhận
	                                        	<%}else if(orders.get(i).getState()==2){ %>
	                                        		Đang giao
	                                        	<%}else if(orders.get(i).getState()==3){ %>
	                                        		Đã giao
	                                        	<%}else{ %>
	                                        		Đã hủy
	                                        	<%} %>
	                                        </td>
	                                        <td>
	                                            <a href="/BTL_LTW/DetailSuccessOrder?id=<%=orders.get(i).getId() %>">
	                                                Details
	                                            </a>
	                                        </td>
	                                    </tr>
                                	<%} %>
                                </tbody>
                            </table>
                        </div>

                    </div>
                    <div id="menu1" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">STT</th>
                                    <th class="none">Địa chỉ</th>
                                    <th class="none">Số điện thoại</th>
                                    <th>Mặt hàng</th>
                                    <th class="none">Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <%for(int i=0; i<orders.size(); i++){ %>
                                    	<%if(orders.get(i).getState()==0){ %>
                                    		<tr>
		                                        <td><%=i+1 %></td>
		                                        <td class="none"><%=orders.get(i).getAddress() %></td>
		                                        <td class="none"><%=client.getPhone() %></td>
		                                        <td>
		                                            <%for(int j=0; j<orders.get(i).getOrderItem().size(); j++){ %>
		                                        		<p><%=orders.get(i).getOrderItem().get(j).getQuantity() %>
		                                        		 &nbsp;<%=orders.get(i).getOrderItem().get(j).getCakeName() %></p>
		                                        	<%} %>
		                                        </td>
		                                        <td class="none"><%=orders.get(i).getTotal() %></td>
		                                        <td>Chờ xác nhận</td>
		                                        <td>
		                                            <a href="/BTL_LTW/DetailSuccessOrder?id=<%=orders.get(i).getId() %>">
		                                                Details
		                                            </a>
		                                        </td>
		                                    </tr>
                                		<%} %>
                                	<%} %>
                                </tbody>
                            </table>
                        </div>

                    </div>
                    <div id="menu2" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">STT</th>
                                    <th class="none">Địa chỉ</th>
                                    <th class="none">Số điện thoại</th>
                                    <th>Mặt hàng</th>
                                    <th class="none">Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <%for(int i=0; i<orders.size(); i++){ %>
                                    	<%if(orders.get(i).getState()==1){ %>
                                    		<tr>
		                                        <td><%=i+1 %></td>
		                                        <td class="none"><%=orders.get(i).getAddress() %></td>
		                                        <td class="none"><%=client.getPhone() %></td>
		                                        <td>
		                                        	<%for(int j=0; j<orders.get(i).getOrderItem().size(); j++){ %>
		                                        		<p><%=orders.get(i).getOrderItem().get(j).getQuantity() %>
		                                        		 &nbsp;<%=orders.get(i).getOrderItem().get(j).getCakeName() %></p>
		                                        	<%} %>
		                                        </td>
		                                        <td class="none"><%=orders.get(i).getTotal() %></td>
		                                        <td>Đã xác nhận</td>
		                                        <td>
		                                            <a href="/BTL_LTW/DetailSuccessOrder?id=<%=orders.get(i).getId() %>">
		                                                Details
		                                            </a>
		                                        </td>
		                                    </tr>
                                		<%} %>
                                	<%} %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="menu3" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">STT</th>
                                    <th class="none">Địa chỉ</th>
                                    <th class="none">Số điện thoại</th>
                                    <th>Mặt hàng</th>
                                    <th class="none">Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <%for(int i=0; i<orders.size(); i++){ %>
                                    	<%if(orders.get(i).getState()==2){ %>
                                    		<tr>
		                                        <td><%=i+1 %></td>
		                                        <td class="none"><%=orders.get(i).getAddress() %></td>
		                                        <td class="none"><%=client.getPhone() %></td>
		                                        <td>
		                                            <%for(int j=0; j<orders.get(i).getOrderItem().size(); j++){ %>
		                                        		<p><%=orders.get(i).getOrderItem().get(j).getQuantity() %>
		                                        		 &nbsp;<%=orders.get(i).getOrderItem().get(j).getCakeName() %></p>
		                                        	<%} %>
		                                        </td>
		                                        <td class="none"><%=orders.get(i).getTotal() %></td>
		                                        <td>Đang giao</td>
		                                        <td>
		                                            <a href="/BTL_LTW/DetailSuccessOrder?id=<%=orders.get(i).getId() %>">
		                                                Details
		                                            </a>
		                                        </td>
		                                    </tr>
                                		<%} %>
                                	<%} %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="menu4" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
                                    <th style="width: 40px;">STT</th>
                                    <th class="none">Địa chỉ</th>
                                    <th class="none">Số điện thoại</th>
                                    <th>Mặt hàng</th>
                                    <th class="none">Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <%for(int i=0; i<orders.size(); i++){ %>
                                    	<%if(orders.get(i).getState()==3){ %>
                                    		<tr>
		                                        <td><%=i+1 %></td>
		                                        <td class="none"><%=orders.get(i).getAddress() %></td>
		                                        <td class="none"><%=client.getPhone() %></td>
		                                        <td>
		                                            <%for(int j=0; j<orders.get(i).getOrderItem().size(); j++){ %>
		                                        		<p><%=orders.get(i).getOrderItem().get(j).getQuantity() %>
		                                        		 &nbsp;<%=orders.get(i).getOrderItem().get(j).getCakeName() %></p>
		                                        	<%} %>
		                                        </td>
		                                        <td class="none"><%=orders.get(i).getTotal() %></td>
		                                        <td>Đã giao</td>
		                                        <td>
		                                            <a href="/BTL_LTW/DetailSuccessOrder?id=<%=orders.get(i).getId() %>">
		                                                Details
		                                            </a>
		                                        </td>
		                                    </tr>
                                		<%} %>
                                	<%} %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                	<div id="menu5" class="none-view">
                        <div class="table-responsive">
                            <table>
                                <thead>
									<th style="width: 40px;">STT</th>
                                    <th class="none">Địa chỉ</th>
                                    <th class="none">Số điện thoại</th>
                                    <th>Mặt hàng</th>
                                    <th class="none">Tổng tiền</th>
                                    <th>Trạng thái</th>
                                    <th></th>
                                </thead>
                                <tbody>
                                    <%for(int i=0; i<orders.size(); i++){ %>
                                    	<%if(orders.get(i).getState()==4){ %>
                                    		<tr>
		                                        <td><%=i+1 %></td>
		                                        <td class="none"><%=orders.get(i).getAddress() %></td>
		                                        <td class="none"><%=client.getPhone() %></td>
		                                        <td>
		                                            <%for(int j=0; j<orders.get(i).getOrderItem().size(); j++){ %>
		                                        		<p><%=orders.get(i).getOrderItem().get(j).getQuantity() %>
		                                        		 &nbsp;<%=orders.get(i).getOrderItem().get(j).getCakeName() %></p>
		                                        	<%} %>
		                                        </td>
		                                        <td class="none"><%=orders.get(i).getTotal() %></td>
		                                        <td>Đã hủy</td>
		                                        <td>
		                                            <a href="/BTL_LTW/DetailSuccessOrder?id=<%=orders.get(i).getId() %>">
		                                                Details
		                                            </a>
		                                        </td>
		                                    </tr>
                                		<%} %>
                                	<%} %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
	<jsp:include page="footer.jsp"/>
	
	<script type="text/javascript">Ư
		const url = "http://localhost:8080/BTL_LTW/api/ordersByClient?id="+<%=client.getID()%>;
		console.log(url);
		fetch(url)
		.then (data => {return data.json()})
		.then (res => {
			console.log(res);	
			document.getElementById("cake").innerHTML = res[0].orderDetail[0].cakeName;
			
		})
		console.log(k);
	</script>
</body>
</html>