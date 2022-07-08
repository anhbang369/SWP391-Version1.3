<%-- 
    Document   : receipt
    Created on : Jun 16, 2022, 4:27:44 PM
    Author     : 84348
--%>

<%@page import="receiptAccountant.UserReceiptDetailS"%>
<%@page import="user.UserNotify"%>
<%@page import="user.UserProduct"%>
<%@page import="receiptAccountant.UserReceipt"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/mycode.js"></script>
        <title>Receipt Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=&searchSeceond=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>

        <a href="MainController?action=AddReceiptVirtual">Create</a>

        <form action="MainController">
            <input type="text" name="search" placeholder="By Receipt ID"/>
            <input type="submit" name="action" value="SeacrhReceipt"/>
        </form>

        <form action="">

            <i class="fa-solid fa-filter" onclick="ShowDateReceipt()"></i>

        </form>
        <div class="show_date_receipt" id="showDateReceipt">
            <form action="MainController">
                Search<input type="date" name="search"/>
                To<input type="date" name="searchR" />
                <input type="submit" name="action" value="SearchReceiptDate"/>
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
            List<UserReceipt> receipt = (List<UserReceipt>) request.getAttribute("LIST_RECEIPT");
            if (receipt != null) {
                if (receipt.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Receipt ID</th>
                    <th>Create date</th>
                    <th>Status</th>
                    <th>Total Quantity</th>
                    <th>Note</th>
                    <th>accountantID</th>
                    <th>stockKeeperID</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserReceipt rc : receipt) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="receiptID" value="<%= rc.getReceiptID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getInputDate()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getStatus()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getTotalQuantity()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getNote()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getAccountantID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= rc.getStockKeeperID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="ShowDetailReceipt" readonly=""/>
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
        List<UserReceiptDetailS> receiptDetail = (List<UserReceiptDetailS>) request.getAttribute("LIST_DETAIL_RECEIPT");
        if (receiptDetail != null) {
            if (receiptDetail.size() > 0) {
    %>
    <div id="orderDetail">
        <table  border="1" >
            <thead>
                <tr>
                    <th>receiptDetailID</th>
                    <th>quantityInBill</th>
                    <th>quantityInShipping</th>
                    <th>productID</th>
                    <th>receiptID</th>
                    <th>solution</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserReceiptDetailS tm : receiptDetail) {
                %>
                <tr>
                    <td>
                        <input type="text" name="orderDetailID" value="<%= tm.getReceiptDetailID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="quantity" value="<%= tm.getQuantityInBill()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="orderID" value="<%= tm.getQuantityInShipping()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= tm.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= tm.getReceiptID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= tm.getSolution()%>" readonly=""/>
                    </td>
                    
                </tr>
                <%
                    }
                %>
            <input type="button" value="Close" onclick="ShowDetailOrder()">
            </tbody>          
        </table>
    </div>
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
