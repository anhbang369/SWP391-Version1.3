<%-- 
    Document   : issueVirtual
    Created on : Jun 17, 2022, 10:20:13 PM
    Author     : 84348
--%>

<%@page import="issueAccountant.UserOrderDetail"%>
<%@page import="issueAccountant.UserIssueS"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/backNoWork.js" type="text/javascript" ></script>
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/mycode.js"></script>
        <title>Create Issue Virtual Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>

        <form action="MainController">
            <input type="text" name="searchIssue" placeholder="Enter OrderID">
            <input type="text" name="searchCustomer" placeholder="Enter Customer Name">
            <input type="submit" name="action" value="SearchIssue">
        </form>

        <%
            List<UserIssueS> issue = (List<UserIssueS>) request.getAttribute("LIST_ISSUE");
            if (issue != null) {
                if (issue.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>issueID</th>
                    <th>Note</th>
                    <th>accountantID</th>
                    <th>sellerID</th>
                    <th>orderID</th>
                    <th>DateP</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserIssueS tm : issue) {
                %>
            <form action="MainController">
                <tr>
                    <td>
                        <input type="text" name="issueID" value="<%= tm.getIssueID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="note" value="<%= tm.getNote()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="accountantID" value="<%= tm.getAccountantID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="sellerID" value="<%= tm.getSellerID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="orderID" value="<%= tm.getOrderID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="DateP" value="<%= tm.getDateP()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="ShowDetailOrder"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="UpdateIssue"/>
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
        List<UserOrderDetail> issueDetail = (List<UserOrderDetail>) request.getAttribute("LIST_ORDER_DETAIL");
        if (issueDetail != null) {
            if (issueDetail.size() > 0) {
    %>
    <div id="orderDetail">
        <form action="MainController">
        
        <table  border="1" >
            <thead>
                <tr>
                    <th>orderDetailID</th>
                    <th>quantity</th>
                    <th>orderID</th>
                    <th>productID</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserOrderDetail tm : issueDetail) {
                %>
                <tr>
                    <td>
                        <input type="text" name="orderDetailID" value="<%= tm.getOrderDetailID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="quantity" value="<%= tm.getQuantity()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="orderID" value="<%= tm.getOrderID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= tm.getProductID()%>" readonly=""/>
                    </td>
                    
                </tr>
                <%
                    }
                %>
            <input type="button" value="Close" onclick="ShowDetailOrder()">
            </tbody>          
        </table>
            <input type="submit" name="action" value="ExportIssue">
           </form> 
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


