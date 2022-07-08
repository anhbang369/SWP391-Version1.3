<%-- 
    Document   : createSuccessReceipt
    Created on : Jun 16, 2022, 4:26:18 PM
    Author     : 84348
--%>

<%@page import="receiptAccountant.UserFakeList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Success Receipt Page</title>
    </head>
    <body>
        <a href="MainController?action=ShowRequest&showRequest=&howRequest=">Request</a>
        <a href="MainController?action=SeacrhReceipt&search=">Receipt</a>
        <a href="MainController?action=SeacrhOrder&OrderI=&CustomerNam=&Addres=&PhoneNumbe=">Issue</a>
        <a href="report.jsp">Report</a>
        <a href="MainController?action=SearchInventoryF&searchInventoryF=">Inventory Report</a>

        <form action="MainController">
            <%
                List<UserFakeList> list = (List<UserFakeList>) request.getAttribute("LIST_ALL_RECEIPT");
                if (list != null) {
                    if (list.size() > 0) {

            %>

            <table border="1">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Model</th>
                        <th>Brand</th>
                        <th>type</th>
                        <th>receiptDetailID</th>
                        <th>Quantity In Bill</th>
                        <th>quantity In Shipping</th>
                        <th>solution</th>
                    </tr>
                </thead>
                <tbody>
                    <%                    for (UserFakeList elem : list) {


                    %>
                    Input Date: <%=elem.getInputDate()%></br>
                    Status: <%=elem.getStatus()%></br>
                    Accountant ID: <%=elem.getAccountantID()%></br>
                    StockKeeper ID: <%=elem.getStockKeeperID()%></br>
                    Total Quantity: <%=elem.getTotalQuantity()%></br>
                    <%
                            break;
                        }
                    %>

                    <%
                        for (UserFakeList rc : list) {

                    %>

                    <tr>
                        <td>
                            <input type="text" name="productID" value="<%= rc.getProductID()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="model" value="<%= rc.getModel()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="brand" value="<%= rc.getBrand()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="type" value="<%= rc.getType()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="number" name="receiptDetailID" value="<%= rc.getReceiptDetailID()%>" />
                        </td>
                        <td>
                            <input type="number" name="quantityInBill" value="<%= rc.getQuantityInBill()%>" />
                        </td>
                        <td>
                            <input type="number" name="quantityInShipping" value="<%= rc.getQuantityInShipping()%>"/>
                        </td>
                        <td>
                            <input type="text" name="solution" value="<%= rc.getSolution()%>"/>
                        </td>
                <input type="hidden" name="inputDate" value="<%= rc.getInputDate()%>" readonly=""/>
                <input type="hidden" name="status" value="<%= rc.getStatus()%>" readonly=""/>
                <input type="hidden" name="accountantID" value="<%= rc.getAccountantID()%>" readonly=""/>
                <input type="hidden" name="stockKeeperID" value="<%= rc.getStockKeeperID()%>" readonly=""/>
                <input type="hidden" name="totalQuantity" value="<%= rc.getTotalQuantity()%>" readonly=""/>
                <input type="hidden" name="note" value="<%= rc.getNote()%>" readonly=""/>
                </tr>   

                </tbody>
                <%

                    }
                %>
            </table>



            <%
                    }
                }
            %>
            
           
                <input type="text" name="conclusion" placeholder="Enter Conclusion">
                <input type="submit" name="action" value="Conclusion">
            
            <input type="submit" name="action" value="Export">
        </form>
    </body>
</html>
