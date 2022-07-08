<%-- 
    Document   : issue
    Created on : Jun 17, 2022, 8:57:17 PM
    Author     : 84348
--%>

<%@page import="user.UserNotify"%>
<%@page import="issueAccountant.UserOrder"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/mycode.js"></script>
        <title>Order Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>
        <form action="MainController">
            <input type="number" name="OrderI" placeholder="OrderID"/>
            <input type="text" name="CustomerNam" placeholder="CustomerName"/>
            <input type="text" name="Addres" placeholder="Address"/>
            <input type="number" name="PhoneNumbe" placeholder="PhoneNumber"/>
            <input type="submit" name="action" value="SeacrhOrder"/>
        </form>

        <form action="">
        
        <i class="fa-solid fa-filter" onclick="ShowDateReceipt()"></i>
      
    </form>
    <div class="show_date_receipt" id="showDateReceipt">
        <form action="MainController">
            Search<input type="date" name="search"/>
            To<input type="date" name="searchM" />
            <input type="submit" name="action" value="SearchOrderDate"/>
        </form>
    </div>



        <form action="#" method="post">
            <i class="fa-regular fa-bell" value="show" onclick="ShowNotify()"></i>
        </form>
        <%
            List<UserNotify> product = (List<UserNotify>) request.getAttribute("LIST_NOTIFY");
            if (product != null) {
                if (product.size() > 0) {
        %>
        
        
        
        <div class="number" id="sa<%= product.size()%>">
                <%= product.size() %>
            </div>
        <div class="notification_head" id="showValue">
            <header class="head_notify">
                <h3>
                    Thông báo mới nhận
                </h3>
            </header>
            <%
                for (UserNotify list : product) {
            %>
            <ul>
                <li class="notify_list">
                    <span> Mặc hàng <%= list.getName()%> trong kho đang ở mức báo động. Cần xem xét nhập hàng </span>
                </li>

            </ul>
            <%
                }
            %>
        </div>
        <%
                }
            }
        %>








        <%
            List<UserOrder> order = (List<UserOrder>) request.getAttribute("LIST_ORDER");
            if (order != null) {
                if (order.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>OrderID</th>
                    <th>CustomerName</th>
                    <th>Address</th>
                    <th>PhoneNumber</th>
                    <th>Status</th>
                    <th>note</th>
                    <th>deliveryDate</th>
                    <th>sellerID</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserOrder rc : order) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="orderID" value="<%= rc.getOrderID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="customerName" value="<%= rc.getCustomerName()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="address" value="<%= rc.getAddress()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="phoneNumber" value="<%= rc.getPhoneNumber()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="status" value="<%= rc.getStatus()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="note" value="<%= rc.getNote()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="deliveryDate" value="<%= rc.getDeliveryDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="sellerID" value="<%= rc.getSellerID()%>" />
                    </td>
                    <td>
                        <input type="submit" name="action" value="InsertIssue" />
                    </td>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <%
            }
        }
    %>

    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    %>
    <h2><%=error%></h2>
</body>
</html>
