<%@page import="modelDAO.CakeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="modelDAO.CakeDAO"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
	<% ArrayList<Cake> listProduct = (ArrayList<Cake>)request.getAttribute("products"); %>
		<div style="font-size: 25px; height: 100px;float: left;">
		    <a href="${pageContext.request.contextPath}/StaffListOrders" class="button">
		    	<button style="padding: 7px 10px">QUAY LẠI</button>
		    </a>
		</div>
		<div style="font-size: 25px; height: 100px;float: right;">
		    <a href="${pageContext.request.contextPath}/StaffLogout" class="button">ĐĂNG XUẤT</a>
		</div>
        <div style="text-align: center;font-size: 50px; width: 100%; height: 100px;float: left; margin:30px 0px;">
		    Danh sách đơn hàng
		</div>
		<div style="font-size: 25px; height: 100px;float: left;">
		    <a href="${pageContext.request.contextPath}/StaffAddProduct" class="button">
		    	<button style="position: relative; left: 130px; padding: 7px 10px; width: 140px;">Thêm sản phẩm</button>
		    </a>
		</div>
        <table border="2" cellpadding="10px">
            <tr>
                
                <th>Mã</th>
                <th>Tên</th>
                <th>Giá tiền</th>
                <th>Mô tả</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
			
			
            <%for(int i=0;i<listProduct.size();i++){
            	
            	%>
            	<tr>
                <td><%=listProduct.get(i).getID() %></td>
                <td><%=listProduct.get(i).getName() %></td>
                <td><%=listProduct.get(i).getPrice() %></td>
                <td><%=listProduct.get(i).getDescription() %></td>
                <td><a href="EditProduct?id=<%=listProduct.get(i).getID()%>"><button>Edit</button></a></td>
                <td><a href="DeleteProduct?id=<%=listProduct.get(i).getID()%>"><button>Delete</button></a></td>
            </tr>
            	
            	
            <% }%>

            </table><br>
        
    </body>
    <script >function quit() {
        location.href="AdminHome";
    }</script>
</html>