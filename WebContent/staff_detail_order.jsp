
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.*" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
    <title>Title</title>
    <style>
    	a, a:hover{
    		text-decoration: none;
    		color: black;
    	}
        table {
            clear: both;
            width: 80%;
            margin-left: 10%;
            padding-top: 2%;
            border-collapse: collapse;
            border: black 1px solid;
            margin-bottom: 20px;
        }
        th {
            border-collapse: collapse;
            border: black 1px solid;
        }

        td {
            text-align: center;
            border-collapse: collapse;
            border: black 1px solid;
            min-height: 3vh;
        }
        button{
            width: 2cm;
            height: 1cm;
            font-size: 15px;
        }
        a.button{
		    display: inline-block;
		    text-align: center;
		    width: 105px;
		    padding: 13px 0px;
		    font-size: 14px;
		/* 		    color: black; */
		    border: 1px solid transparent;
		    cursor: pointer;
		    z-index: 3;
		}
		a.button:hover{
			color: red;
		}
		button{
			width: 100px;
		    text-align: center;
		    font-size: 15px;
		    padding: 5px 7px;
		
		}

    </style>
</head>
<body>
	<% 
		Order order=(Order)request.getAttribute("order");
		Client client=(Client)request.getAttribute("client");
	    List<Cake> cakes = (List<Cake>)request.getAttribute("cakes"); 
	    List<Cake_Order> cakeOrders = (List<Cake_Order>)request.getAttribute("cakeOrders"); 
	%>
	<div style="font-size: 25px; height: 100px;float: left;">
	    <a href="/BTL_LTW/StaffListOrders" class="button">
	    	<button style="padding: 7px 10px">QUAY LẠI</button>
	    </a>
	</div>
	<div style="font-size: 25px; height: 100px;float: right;">
	    <a href="/BTL_LTW/StaffLogout" class="button">ĐĂNG XUẤT</a>
	</div>
    <div style="width: 100%;text-align: center;font-size: 40px;float: left; margin-bottom: 40px">
        CHI TIẾT ĐƠN HÀNG
    </div>
    <div style="width: 40%;text-align: left;font-size: 20px;height: 45px;float: left; padding-left: 10%">
            Mã khách hàng :<%=client.getID() %>
        <br>
            Tên khách hàng :<%=client.getName() %>
    </div>
    <div style="width: 100%;font-size: 20px;height: 21px;float: left;padding-left: 10%">
        Tổng chi phí : <%=order.getTotal() %>
    </div>
    <div style="width: 100%;font-size: 20px;height: 35px;float: left;padding-left: 10%">
        Trạng thái đơn hàng : 
        <%if(order.getState()==0){ %>
       		Chờ xác nhận
       	<%}else if(order.getState()==1){ %>
       		Đã xác nhận
       	<%}else if(order.getState()==2){ %>
       		Đang giao
       	<%}else if(order.getState()==3){ %>
       		Đã giao
       	<%}else{ %>
       		Đã hủy
       	<%} %>
    </div>
    <div style="width: 100%;text-align: center;font-size: 30px;float: left">
        <table>
            <tr>
                <th>
                    Mã Bánh
                </th>
                <th>
                    Tên Bánh
                </th>
                <th>
                    Giá
                </th>
                <th>
                    Số lượng
                </th>
                <th>
                    Thành tiền
                </th>
            </tr>
            <%for(int i=0; i<cakes.size(); i++){ %>
            	<tr>
	                <th><%=cakes.get(i).getID() %></th>
	                <th><%=cakes.get(i).getName() %></th>
	                <th><%=cakes.get(i).getPrice() %></th>
	                <th>
	                	<%for(int j=0; j<cakeOrders.size(); j++){ 
                       		if(cakeOrders.get(j).getCakeID()==cakes.get(i).getID()){
                       			%>
                       			<%= cakeOrders.get(j).getQuantity() %>
                       			<% 
                       			break;
                       		}
                       	} %>
	                </th>
	                <th>
		                <% int price = 0;
	                    for(int j=0; j<cakeOrders.size(); j++){ 
                       		if(cakeOrders.get(j).getCakeID()==cakes.get(i).getID()){
                       			price = price + cakeOrders.get(j).getQuantity()*cakes.get(i).getPrice();
                       			break;
                       		}
	                     }
	                     %>
	                     <%=price %>
	                </th>
	            </tr>
            <%} %>
            
        </table>
    </div>
    
    <%if(order.getState()!=3 && order.getState()!=4){ %>
    	<% String valueBt="";
    	if(order.getState()==0){ 
    		valueBt="Xác nhận";
    	}else if(order.getState()==1){ 
			valueBt="Đóng gói và giao";
    	}else if(order.getState()==2){
    		valueBt="Thành công";
    	}%>
	    <div style="width: 50%;text-align: center;font-size: 30px;height:50px;float: left">
	        <form action="/BTL_LTW/StaffUpdateStateOrder" method="get">
	            <input type="hidden" value="<%=order.getState()+1 %>" name="state">
	            <input type="hidden" value="<%=order.getID() %>" name="id">
	            <input type="submit" style="padding:7px 10px;font-size: 15px" value="<%=valueBt%>" onclick="return xacNhan1()">
	        </form>
	    </div>
    <%} %>
    <%if(order.getState()==0){ %>
    	<div style="width: 50%;text-align: center;font-size: 30px;height:50px;float: left">
        <a href="/BTL_LTW/StaffCancelOrder?id=<%=order.getID()%>">
            <input type="button" style="width:70px;padding:7px 10px;font-size: 15px" value="hủy" onclick="return xacNhan2()">
        </a>
    </div>
    <%} %>
    
</body>
<script type="text/javascript">
	function xacNhan1() {
	  if (confirm("Bạn có chắc muốn cập nhật trạng thái đơn hàng không?")) {
	    return true;
	  } else {
	    return false;
	  }
	}
	function xacNhan2() {
		  if (confirm("Bạn có chắc muốn hủy đơn không?")) {
		    return true;
		  } else {
		    return false;
		  }
		}
</script>
</html>
