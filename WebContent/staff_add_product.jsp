<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  <%@page import="models.*"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>AddProduct</title>
</head>
<body>
	<form action="AddProduct" method="post" accept-charset="UTF-8">
	<table border="2" cellpadding="10px" style="margin-top:50px" >
		<tr>
                
                <th>Tên</th>
                <th>Price</th>
                <th>Mô tả</th>
                <th>Loại</th>
                <th>Giá</th>
               
        </tr>
        <tr>
                <td><input type="text" name="name"></td>
                
                <td><input type="text" name="price"></td>
                <td><input type="text" name="description"></td>
                <td><input type="text" name="type"></td>
                <td><input type="text" name="price"></td>
         </tr>
         
		<tr><th>Ảnh 1</th>
                <th>Ảnh 2</th>
                <th>Ảnh 3</th>
                <th>Ảnh 4</th> </tr>
        <tr>
        	<td><input type ="file" name="img1"></td>
                <td><input type ="file" name="img2"></td>
                <td><input type ="file"  name="img3"></td>
                <td><input type ="file" name="img4"></td>
        
        </tr>
	
	
	
	
	 </table><br>
	 <input type="submit" value="Thêm Sản Phẩm">
	
	
	</form>
	
</body>
</html>