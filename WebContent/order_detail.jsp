
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            clear: both;
            width: 80%;
            margin-left: 10%;
            padding-top: 2%;
            border-collapse: collapse;
            border: black 1px solid;
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

    </style>
</head>
<body>
<%--     <% --%>
<!-- //         OrderedItemDAO orderedItemDAO = new OrderedItemDAOImpl(); -->
<!-- //         int id = (int) session.getAttribute("orderId"); -->
<!-- //         OrderBillDAO orderBillDAO = new OrderBillDAOImpl(); -->
<!-- //         OrderBill orderBill = orderBillDAO.getById(id); -->
<!-- //         ArrayList<OrderedItem> list = (ArrayList<OrderedItem>) orderedItemDAO.getAllByOrderId(id); -->
<!--     %> -->
    <div style="width: 100%;text-align: center;font-size: 100px;height: 200px;float: left">
        CHI TIẾT ĐƠN HÀNG
    </div>
    <div style="text-align: center;font-size: 20px; width: 100%; height: 100px;float: left">
        <a href="staff_home.jsp" style="display: none" id="newOrder">Có đơn hàng mới</a>
    </div>
    <div style="width: 50%;text-align: center;font-size: 20px;height: 100px;float: left">
            Mã khách hàng :111
<%--              <%= orderBill.getCustomer().getId()%> --%>
        <br>
            Tên khách hàng : NP Thao
<%--             <%= orderBill.getCustomer().getName()%> --%>
    </div>
    <div style="width: 50%;text-align: center;font-size: 20px;height: 100px;float: left">
        Mã nhân viên : 123
<%--         <%= orderBill.getStaffCode()%> --%>
        <br>
        Tên nhân viên : Chu Van Dang
<%--         <%= orderBill.getStaffName()%> --%>
    </div>
    <div style="width: 100%;text-align: center;font-size: 30px;float: left">
        <table>
            <tr>
                <th>
                    Mã Sách
                </th>
                <th>
                    Tên sách
                </th>
                <th>
                    Tác giả
                </th>
                <th>
                    Thể loại
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
<%--             <% --%>
<!-- //                 for(int i = 0 ; i < list.size() ; i++){ -->
<!--             %> -->
            <tr>
                <th>111
<%--                     <%= list.get(i).getBook().getId()%> --%>
                </th>
                <th>Toan
<%--                     <%= list.get(i).getBook().getName()%> --%>
                </th>
                <th>Thao
<%--                     <%= list.get(i).getBook().getAuthor()%> --%>
                </th>
                <th>Giao Khoa
<%--                     <%= list.get(i).getBook().getCategory()%> --%>
                </th>
                <th>123.000
<%--                     <%= list.get(i).getBook().getPrice()%> --%>
                </th>
                <th>2
<%--                     <%= list.get(i).getQuantity()%> --%>
                </th>
                <th>240.000
<%--                     <%= list.get(i).getQuantity()*list.get(i).getBook().getPrice()%> --%>
                </th>
            </tr>
<%--             <% --%>
<!-- //                 } -->
<%--             %> --%>
        </table>
    </div>
    <div style="width: 100%;font-size: 20px;height: 30px;float: left;padding-left: 10%">
        Tổng chi phí : 230.000
<%--         <% double cost = 0; for(OrderedItem dem : list){ --%>
<!-- //             double price = dem.getBook().getPrice(); -->
<!-- //             double quantity = Double.parseDouble(dem.getQuantity().toString()); -->
<!-- //             cost = cost + price*quantity; -->
<!-- //         }; -->
<!-- //         out.print(cost); -->
<%--     %> --%>
<%--         <% --%>
<!-- //             String status = orderBill.getStatus(); -->
<!-- //             String buttonStatus = null; -->
<!-- //             if(status.equals(OrderBill.STATUS.WAIT_CONFIRM)){ -->
<!-- //                 buttonStatus = OrderBill.STATUS.CONFIRMED; -->
<!-- //             } -->
<!-- //             else if(status.equals((OrderBill.STATUS.CONFIRMED))){ -->
<!-- //                 buttonStatus = OrderBill.STATUS.SHIPPING; -->
<!-- //             } -->
<!-- //             else{ -->
<!-- //                 buttonStatus = OrderBill.STATUS.DONE; -->
<!-- //             } -->
<%--         %> --%>
    </div>
    <div style="width: 100%;font-size: 20px;height: 30px;float: left;padding-left: 10%">
        Trạng thái đơn hàng : Thanh cong
<%--         <%= orderBill.getStatus()%> --%>
    </div>
    <div style="width: 50%;text-align: center;font-size: 30px;height:50px;float: left">
<%--     <% --%>
<!-- //         if(!status.equals(OrderBill.STATUS.DONE)){ -->
<%--     %> --%>
        <form action="order-update" method="post">
            <input type="hidden" value="update" name="update">
            <input type="submit" style="width: 3cm;height: 1cm;font-size: 15px" value=" Thanh cong
<%--             <%=buttonStatus%> --%>
            ">
        </form>
<%--       <% --%>
<!-- //           } -->
<%--       %> --%>
    </div>
    <div style="width: 50%;text-align: center;font-size: 30px;height:50px;float: left">
        <form action="order-update" method="post">
            <input type="hidden" value="cancel" name="cancel">
            <input type="submit" style="width: 2cm;height: 1cm;font-size: 15px" value="hủy">
        </form>
    </div>
<%--     <% --%>
<!-- //         ArrayList<OrderBill> list2 = (ArrayList<OrderBill>) session.getAttribute("listOrderBill"); -->
<%--     %> --%>
<script>
    setInterval(function () {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                if(this.responseText=="true"){
                    document.getElementById("newOrder").setAttribute("style","display : inline")
                };
            }
        };
<%--         var length = <%=list2.size()%>; --%>
        xhttp.open("POST", "check-new-orderBill-on-billList", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("length="+length);
    },3000)
</script>
</body>
</html>
